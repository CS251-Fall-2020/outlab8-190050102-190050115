#!/bin/bash

if [ $# -ne 4 ]; then
    echo "usage : checker.sh r1 r2 w1 w2"
    exit 1
fi

rm -f r1.txt r2.txt w1.txt w2.txt output

for i in $(seq 1 $1);
do
    echo $(($RANDOM % 128)) >> r1.txt
done

for i in $(seq 1 $2);
do
    echo $(($RANDOM % 128)) >> r2.txt
done

for i in $(seq 1 $3);
do
    echo $(($RANDOM % 128)) >> w1.txt
done

for i in $(seq 1 $4);
do
    echo $(($RANDOM % 128)) >> w2.txt
done

java readwrite.FinalTester > output

if [ $(cat output | wc -l) -ne $(( $1 + $2 + 2 * $3 + 2 * $4 )) ]; then
    echo "Incorrect code - number of lines in output don't match"
    exit 1
fi

if [ $(head -n1 output) != "WE" ]; then
    echo "First line is not WE"
    exit 1
fi

we=0

while read inp; do
    if [ $we -eq 0 ]; then
        if [ $inp == "WE" ]; then
            we=1
        elif [ $inp == "WX" ]; then
            echo "unnecessary WX encountered"
            exit 1
        fi
    else
        if [ $inp != "WX" ];then
            echo "WE has no following WX"
            exit 1
        else
            we=0
        fi
    fi
done < output

while read inp; do
    if [ $inp == "WE" ]; then
        we=$(( $we + 1 ))
    elif [ $inp == "RS" ]; then
        we=$(( $we - 1 ))
    fi
    if [ $we -lt 0 ];then
        echo "A prefix has insufficient writes"
        exit 1
    fi
done < output

echo "Works"