package readwrite;

class Tree{
    boolean assigned;
    int key;
    Tree left, right;

    Tree(){
        assigned = false;
        left = right = null;
    }

    public void write(int _key) throws InterruptedException {
        if(assigned == false){
            key = _key;
            assigned = true;
            return;
        }

        if(key < _key){
            if(right == null){
                right = new Tree();
            }
            right.write(_key);
        }else{
            if(left == null){
                left = new Tree();
            }
            left.write(_key);
        }
        return;
    }

    public int read(int _key) throws InterruptedException {
        if(key == _key && assigned) return _key;
        
        if(_key < key){
            if(left == null) return key;
            return left.read(_key);
        }else{
            if(right == null) return key;
            return right.read(_key);
        }
    }

    // public static void main(String args[]) throws Exception{
    //     Scanner sc = new Scanner(System.in);
    //     Tree t = new Tree();
    //     t.write(sc.nextInt());
    //     t.write(sc.nextInt());
    //     t.write(sc.nextInt());
    //     t.write(sc.nextInt());

    //     System.out.println(t.read(sc.nextInt()));
    //     sc.close();
    // }
}