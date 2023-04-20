class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0 , y = 0;
        HashSet<Long>hashSet=new HashSet<Long>();
        for(int i = 0 ; i < obstacles.length ; i++){
            hashSet.add(calHash(obstacles[i]));
        }
        //表示方向，使用一个方向数组，初始指向北
        int dir = 0;
        //静态初始化数组
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int ans = 0;
        for(int command : commands){
            if(command == -1) 
                dir = (dir + 1) % 4;
            else if(command == -2) 
                dir = (dir + 3) % 4;
            else{
                for(int i = 0; i < command; i++){
                    int nx = dx[dir] + x;
                    int ny = dy[dir] + y;
                    int []tmpPlace = new int[]{nx, ny};
                    if(hashSet.contains(calHash(tmpPlace)))
                        break;
                    x = nx;
                    y = ny;
                }
                ans = Math.max(ans, x * x + y * y);
            }  
        }
        return ans;
    }

    long calHash(int[] obstacle){
        return (obstacle[0] + 30000)*600001L + obstacle[1] + 30000;
    }
}