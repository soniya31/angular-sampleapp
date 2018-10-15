package pratices;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int arr[]={1,8,6,2,5,4,8,3,7};
        maxArea(arr);
    }
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        if(height != null && height.length>1){
            int l = 0;
            int u =height.length -1;

            while(l<u){
                if(height[l]<height[u]){
                    maxArea = Math.max(maxArea, Math.min(height[l],height[u])*(u-l));
                    System.out.println(maxArea);
                    l++;
                }
                else{
                    maxArea = Math.max(maxArea, Math.min(height[l],height[u])*(u-l));
                    System.out.println(maxArea);
                    u--;
                }


            }
        }
        System.out.println(maxArea);
        return maxArea;


    }
}
