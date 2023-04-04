package DailyChallenges;

public class optimalPartitionOfString {
    public int partitionString(String s){
        int count=1; 
        boolean chars[] = new boolean[26];
        for(int i=0; i<s.length(); i++){
            int x = s.charAt(i) - 'a';
            if(chars[x]==true){
                chars = new boolean[26];
                chars[x] = true;
                count++;
            } else chars[x]=true;
        }
        return count;
    }
}
