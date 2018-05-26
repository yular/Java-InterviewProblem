/*
*
* Tag: Heap
* Time: O(nlgk)
* Space: O(n)
*/
class Solution {
    private Map<String,Integer> frequencyOfWords;
    
    public Solution(){
        this.frequencyOfWords = new HashMap<String,Integer>();
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        if(words.length == 0 || k == 0){
            return Collections.emptyList();
        }
        
        buildFrequencyOfWords( words );
        
        PriorityQueue<String> pq = new PriorityQueue<>( (w1, w2) -> 
            frequencyOfWords.get( w1 ).equals( frequencyOfWords.get( w2 ) ) ? 
                w2.compareTo( w1 ) : frequencyOfWords.get( w1 ) - frequencyOfWords.get( w2 ) 
        );
        findTopKFrequentElements( pq, k );
        
        return buildElementsList( pq );
    }
    
    private void buildFrequencyOfWords( String[] words ){
        for(String word : words){
            frequencyOfWords.put( word, frequencyOfWords.getOrDefault( word, 0 ) + 1 );
        }
    }
    
    private void findTopKFrequentElements( PriorityQueue<String> pq, int k ){
        for(String word : frequencyOfWords.keySet()){
            pq.offer( word );
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    private List<String> buildElementsList( PriorityQueue<String> pq ){
        final List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        
        return ans;
    }
}
