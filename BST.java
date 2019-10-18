import java.util.Scanner;
public class BST {
	Node root;
	static class Node
	{
		int age;
		String name;
		Node left;
		Node right;
		Node(int age,String name)
		{
			left =null;
			right=null;
			this.name=name;
			this.age=age;
	 
		}
	}
	 
	public static int compare(String n1,String n2) {
	   n1=n1.toLowerCase().replaceAll("\\s+", "");
	   n2=n2.toLowerCase().replaceAll("\\s+", "");
	   int flag=0;
		
		for(int i=0;i<n2.length();i++) 
		{
			int a=(int)n1.charAt(i);	//comparing with the ASCII Value
			int b=(int)n2.charAt(i);
			
			if(a>b) 
			{
				flag=1;
				break;	
			}
			else if(b>a)
			{
				flag=2;
				break;
			}
			else 
			{
				continue;
			}
				
		}
		return flag;	
	}	
	    public static Node min(Node root)
	    {
	    	Node root2=null;
	    	root=root.right;
	    	 while(root.left!=null)
	    	 {
	    		 root=root.left;
	    	 }
	    	 root2=root;
	    	 if(root.right!=null)
	    	 {
	    		 root=root.right;
	    	 }
	    	 else
	    	 {
	    		 root=null;
	    	 }
	    	 
	    	 return root2;
	     }
	
	  public void insert(int age,String name )
	  { 
		  root = insertRec(root,age,name); 
	  } 
	   public Node insertRec(Node root, int age,String name)
	    { 
	    	if (root == null)
	    	{ 
	            root = new Node(age,name); 
	            return root; 
	        } 
	  
	        if (compare(root.name,name)==1) 
	        {
	            root.left = insertRec(root.left,age,name); 
	        }
	        else if (compare(root.name,name)==2) 
	        {
	            root.right = insertRec(root.right,age,name); 
	        }

	        return root; 
	    } 
	    public void inorder() 
	    { 
	        inorderRec(root); 
	     } 
	void deleteKey(int age, String name) 
	    { 
	        root = deleteRec(root, age, name); 
	    } 
	  
	    /* A recursive function to insert a new key in BST */
	    Node deleteRec(Node root, int age, String name) 
	    { 
	        
	        if (root == null)
	        {
	        	return root; 
	        }
	        if ((int)name.toLowerCase().charAt(0)<(int)root.name.toLowerCase().charAt(0)) 
	            root.left = deleteRec(root.left, age, name); 
	        else if ((int)name.toLowerCase().charAt(0)>(int)root.name.toLowerCase().charAt(0)) 
	            root.right = deleteRec(root.right, age,name); 
	  
	        else
	        { 
	            // node with only one child or no child 
	            if (root.left == null) 
	                return root.right; 
	            else if (root.right == null) 
	                return root.left; 
	  
	            // node with two children: Get the inorder successor (smallest in the right subtree) 
	            root.name = minValue(root.right); 
	  
	            // Delete the inorder successor 
	            root.right = deleteRec(root.right, root.age,root.name); 
	        } 
	  
	        return root; 
	    } 
	    
	    public String minValue(Node root) 
	    { 
	        String minv = root.name; 
	        while (root.left != null) 
	        { 
	            minv = root.left.name; 
	            root = root.left; 
	        } 
	        return minv; 
	    } 
	   
	     
	    public static  void inorderRec(Node root) { 
	         if (root != null) 
	         { 
	             inorderRec(root.left); 
	             System.out.println(root.name+" "+root.age); 
	             inorderRec(root.right); 
	         } 
	     }
  public static void main(String[] args) {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	BST tree = new BST();
	    	System.out.println("Enter the Choice");
	    	int flag=1;
	    	while(flag==1)
	    	{
	    		System.out.println("Enter 1 to insert");
	    		System.out.println("Enter 2 to print");
	    		System.out.println("Enter 3 to Delete");
			
	    		int choice = sc.nextInt();
	    		switch(choice)
	    		{
	    			case 1:
	    			{
	    				System.out.println("Enter the numbr of entries you want to enter ");
	    				int n = sc.nextInt();
	    				for(int i=0;i<n;i++)
	    				{
	    					System.out.println("Enter age of person "+ (i+1));
	    					int age = sc.nextInt();
	    					System.out.println("Enter name of person "+(i+1));
	    					String name = sc.next();
	    					tree.insert(age, name);
	    				}
	    				break;
	    			}
	    			case 2:
	    			{
	    				System.out.println("The entries in tree in the inorder form: ");
	    				tree.inorder();
	    				break;
	    			}
				case 3:
	    			{
	    				System.out.println("Enter the name of the person ");
	    				String name = sc.next();
	    				System.out.println("Enter the age of that person");
	    				int age = sc.nextInt();
	    				tree.deleteKey(age,name);
	    				System.out.println("Deletion Sucessful..........!!!!!!!!!");
	    				break;
	    			}
	    		
	    		}
	    		System.out.println("Do you want to continue if yes press 1 otherwise 0");
	    		flag = sc.nextInt();
	    		
	    	}
	       
	    }
}
