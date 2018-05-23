/*
*
* Tag: Data Structure +  Sort
* Time: O(nlgn)
* Space: O(n)
*/
public class Solution {
    private class CharacterBound {
        private final int leftBound;
        private final int rightBound;
        
        public CharacterBound(int leftBound, int rightBound){
            this.leftBound = leftBound;
            this.rightBound = rightBound;
        }
        
        public int getLeftBound(){
            return leftBound;
        }
        
        public int getRightBound(){
            return rightBound;
        }
    };
    
    private class CharacterBoundComparator implements Comparator<CharacterBound> {
        public int compare(CharacterBound a, CharacterBound b){
            return a.getLeftBound() == b.getLeftBound() ? 
                   a.getRightBound() - b.getRightBound() : 
                   a.getLeftBound() - b.getLeftBound();
        }
    };
    
    /**
     * @param str: The scene string
     * @return: Return the length longest scene
     */
    public int getLongestScene(String str) {
        int ans = 0;
        if(str.length() == 0){
            return ans;
        }
        
        final Map<Character, CharacterBound> boundsOfCharacter = new HashMap<>();
        for(int i = 0; i < str.length(); ++ i){
            final char curCharacter = str.charAt(i);
            if( !boundsOfCharacter.containsKey( curCharacter ) ) {
                boundsOfCharacter.put(curCharacter, new CharacterBound(i, i));
            }
            
            final CharacterBound curCharacterBound = boundsOfCharacter.get( curCharacter );
            boundsOfCharacter.put(curCharacter, new CharacterBound(curCharacterBound.getLeftBound(), Math.max(curCharacterBound.getRightBound(), i ) ));
        }
        
        final List<CharacterBound> boundsOfAllCharacters = new ArrayList(boundsOfCharacter.values());
        Collections.sort(boundsOfAllCharacters, new CharacterBoundComparator());
                
        int curLeftBound = boundsOfAllCharacters.get(0).getLeftBound();
        int curRightBound = boundsOfAllCharacters.get(0).getRightBound();
        for(CharacterBound bound : boundsOfAllCharacters){
            ans = Math.max( ans, bound.getRightBound() - bound.getLeftBound() + 1 );
            if( curRightBound > bound.getLeftBound() ){
                curRightBound = Math.max( curRightBound, bound.getRightBound() );
            } else {
                curLeftBound = bound.getLeftBound();
                curRightBound = bound.getRightBound();
            }
            
            ans = Math.max(ans, curRightBound - curLeftBound + 1);
        }
        
        return ans;
    }
}
