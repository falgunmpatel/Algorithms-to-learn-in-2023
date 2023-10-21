public class LevelOrderBuildTree {
    Scanner sc = new Scanner(System.in);

    public class Node{
        int data;
        Node left;
        Node right;

        public Node (int data){
            this.data=data;
        }
    }
    private Node root;
    public LevelOrderBuildTree(){
        createlevelorder();
    }
    private void createlevelorder(){
        System.out.println("enter levels");
        int n = sc.nextInt();
        Queue<Node> qq = new LinkedList<>();
        int item = sc.nextInt();
        Node nn = new Node(item);
        this.root=nn;
        qq.add(nn);
        while (!qq.isEmpty()){
            Node rv = qq.remove();

            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            if(c1!=-1){
                Node n1 = new Node(c1);
                rv.left=n1;
                qq.add(n1);
            }
            if(c2!=-1){
                Node n2 = new Node(c2);
                rv.right=n2;
                qq.add(n2);
            }
        }

    }

    public void preorder(){
        Preorder(this.root);
        System.out.println();
    }
    private void Preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        Preorder(root.left);
        Preorder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//       int n = sc.nextInt();
        LevelOrderBuildTree tree = new LevelOrderBuildTree();
        tree.preorder();
    }
}
