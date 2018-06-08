/*
*
* Tag: Design
* Time: mkdir, read, write: O(n); ls: O(mlgm)
* Space: O(n)
*/
class FileSystem {
    
    private final Directory root;

    public FileSystem() {
        root = new Directory("root");
    }
    
    public List<String> ls(String path) {
        final String[] fileNamesInPath = path.split("/");
        FileObject currentFileObject = root;
        for(int i = 1; i < fileNamesInPath.length; ++ i){
            final String fileName = fileNamesInPath[i];
            currentFileObject = currentFileObject.childFileObjectOf( fileName );
        }
        
        return currentFileObject.getChildrenFileNames();
    }
    
    public void mkdir(String path) {
        final String[] fileNamesInPath = path.split("/");
        Directory currentFileObject = root;
        for(int i = 1; i < fileNamesInPath.length; ++ i){
            final String newDirectoryName = fileNamesInPath[i];
            final Directory newDirectory = new Directory(newDirectoryName);
            currentFileObject = (Directory)currentFileObject.addNewChildFileObject( newDirectory );
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        final String[] fileNamesInPath = filePath.split("/");
        Directory currentFileObject = root;
        for(int i = 1; i < fileNamesInPath.length - 1; ++ i){
            String newDirectoryName = fileNamesInPath[i];
            Directory newDirectory = new Directory(newDirectoryName);
            currentFileObject = (Directory)currentFileObject.addNewChildFileObject( newDirectory );
        }
        
        final String newFileName = fileNamesInPath[fileNamesInPath.length - 1];
        final File newFile = new File( newFileName );
        final File currentFile = (File)currentFileObject.addNewChildFileObject( newFile );        
        currentFile.addFileContent( content );
    }
    
    public String readContentFromFile(String filePath) {
        final String[] fileNamesInPath = filePath.split("/");
        FileObject currentFileObject = root;
        for(int i = 1; i < fileNamesInPath.length; ++ i){
            String currentFileName = fileNamesInPath[i];
            currentFileObject = currentFileObject.childFileObjectOf( currentFileName );
        }
        
        return currentFileObject.getFileContent();
    }
}

enum FileType { FILE, DIR };

abstract class FileObject {
    private String name;
    private FileType type;
    
    public FileObject(String name, FileType type) {
        this.name = name;
        this.type = type;
    }
    
    public abstract List<String> getChildrenFileNames();
    
    public abstract String getFileContent();
    
    public abstract FileObject childFileObjectOf( String fileName );
    
    public String getName(){
        return name;
    }
    
    public FileType getType(){
        return type;
    }
};

class Directory extends FileObject {
    private final Map<String, FileObject> childrenFiles;
    
    public Directory(String name) {
        super(name, FileType.DIR);
        childrenFiles = new HashMap<>();
    }
    
    public List<String> getChildrenFileNames(){
        return childrenFiles.keySet().stream().sorted().collect(Collectors.toList());
    }
    
    public String getFileContent(){
        return "";
    }
    
    public FileObject addNewChildFileObject( FileObject fileObject ){
        if(!childrenFiles.containsKey(fileObject.getName())) {
            childrenFiles.put(fileObject.getName(), fileObject);
        }
        
        return childrenFiles.get(fileObject.getName());
    }
    
    public FileObject childFileObjectOf( String fileName ) {
        return childrenFiles.get( fileName );
    }
};

class File extends FileObject {
    private String content;
    
    public File(String name) {
        super(name, FileType.FILE);
        this.content = "";
    }
    
    public List<String> getChildrenFileNames(){
        return Arrays.asList( getName() );
    }
    
    public String getFileContent(){
        return content;
    }
    
    public void addFileContent( String content ){
        this.content += content;
    }
    
    public FileObject childFileObjectOf( String fileName ) {
        return null;
    }
};
