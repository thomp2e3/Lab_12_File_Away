import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        JFileChooser fileSelection = new JFileChooser();


        fileSelection.setAcceptAllFileFilterUsed( false );

        fileSelection.setFileFilter( new FileNameExtensionFilter( "Text Files (.txt)", "txt" ) );

        File selectedFile;
        String lineString;

        File dir = new File( System.getProperty( "user.dir" ) );
        fileSelection.setCurrentDirectory( dir );

        if (fileSelection.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = fileSelection.getSelectedFile();
            Path path = selectedFile.toPath();
            InputStream in = new BufferedInputStream( Files.newInputStream( path, CREATE ) );
            BufferedReader textFileReader = new BufferedReader( new InputStreamReader( in ) );

            int linesInDocumentCount = 0;
            int wordsInDocumentCount = 0;
            int charactersInDocumentCount = 0;

            while (textFileReader.ready())
            {
                lineString = textFileReader.readLine();
                String[] wordsArray = lineString.split( " " );
                wordsInDocumentCount = wordsInDocumentCount + wordsArray.length;
                charactersInDocumentCount = charactersInDocumentCount + lineString.length();
                linesInDocumentCount++;
            }

            System.out.println("The file that was selected was: " + selectedFile.getName());
            System.out.println( "The number of lines contained in the file is: " + linesInDocumentCount );
            System.out.println( "The number of words contained in the file is: " + wordsInDocumentCount);
            System.out.println( "The total number of characters in the file is: " + charactersInDocumentCount );

        }
        else
        {
            System.out.println("No file was selected.");
        }
    }
}