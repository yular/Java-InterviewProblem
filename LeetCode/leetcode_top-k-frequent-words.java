/*
*
* Tag: Heap
* Time: O(nlgk)
* Space: O(n)
*/
class Solution {
    
    private class Word implements Comparable<Word> {
        private String content;
        private int frequency;
        
        public Word(String content, int frequency){
            this.content = content;
            this.frequency = frequency;
        }
        
        public String getContent(){
            return content;
        }
        
        public int getFrequency(){
            return frequency;
        }
        
        public int compareTo(Word w){
            return this.getFrequency() == w.getFrequency() ? w.getContent().compareTo(this.getContent()) : 
                    (this.getFrequency() - w.getFrequency());
        }
    };
    
    private Map<String,Integer> frequencyOfWords;
    
    public Solution(){
        this.frequencyOfWords = new HashMap<String,Integer>();
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        final List<String> ans = new ArrayList<>();
        if(words.length == 0 || k == 0){
            return ans;
        }
        
        buildFrequencyOfWords( words );
        
        PriorityQueue<Word> pq = new PriorityQueue<>();
        for(Map.Entry<String, Integer> entry : frequencyOfWords.entrySet()){
            Word word = new Word(entry.getKey(), entry.getValue());
            pq.add(word);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.poll().getContent());
        }
        Collections.reverse(ans);
        
        return ans;
    }
    
    private void buildFrequencyOfWords( String[] words ){
        for(String word : words){
            if(frequencyOfWords.containsKey(word)){
                int currentFrequency = frequencyOfWords.get( word ) + 1;
                frequencyOfWords.put(word, currentFrequency);
            } else {
                frequencyOfWords.put(word, 1);
            }
        }
    }
}
