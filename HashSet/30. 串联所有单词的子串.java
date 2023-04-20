
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int tot = 0;
        for(String word : words){
            tot += word.length();
            int val = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, ++val);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i + tot <= s.length(); i++){
            if(valid(s.substring(i,i+tot),words)){
                ans.add(i);
            }
        }
        return ans;
    }

    boolean valid(String str,String[] words){
        int k = words[0].length();
        HashMap<String,Integer> spiltWordMap = new HashMap<>();
        for(int i = 0;i < str.length(); i += k){
            int val = spiltWordMap.getOrDefault(str.substring(i, i + k), 0);
            spiltWordMap.put(str.substring(i, i + k), ++val);
        }
        return equalsMap(spiltWordMap, wordsMap);
    }

    boolean equalsMap(HashMap<String,Integer>sMap,HashMap<String,Integer>wMap){
        for(String k : sMap.keySet()){
            if(!wMap.containsKey(k)){
                return false;
            }
            else if(wMap.get(k).intValue() != sMap.get(k).intValue()){
                return false;
            }
        }
        for(String k : wMap.keySet()){
            if(!sMap.containsKey(k)){
                return false;
            }
            else if(sMap.get(k).intValue() != wMap.get(k).intValue()){
                return false;
            }
        }
        return true;
    }
    HashMap<String,Integer> wordsMap = new HashMap<>(); 
}