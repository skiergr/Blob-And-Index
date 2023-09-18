import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

public class BlobTest {
    
    @Test
    void testGetFileContents() throws IOException, NoSuchAlgorithmException {
        File f = new File ("example.txt");
        f.createNewFile();
        Blob bob = new Blob ("example.txt");
        String s = bob.getFileContents();
        String otherFileContents = TesterHelper.readAFileToAString(bob.getOgName());

        assertEquals("Does not work....", s, otherFileContents);
    }

    @Test
    void testGetShaString() throws IOException, NoSuchAlgorithmException {
        File f = new File ("example.txt");
        f.createNewFile();
        Blob bob = new Blob ("example.txt");
        String s = bob.getShaString();
        String otherSha = TesterHelper.getSha(bob.getOgName());

        assertEquals("Does not work....", s, otherSha);
    }

    @Test
    void testTranslateToSha1() throws IOException, NoSuchAlgorithmException {
        //this method uses the previous method to call on it (getShaString). The contents of the code is the same
        //except the previous returns a string and translateToSha1 doesn't return anything
        //so getShaString is basically a getter for translateToSha1
        //but i know that this method works because the previous works
    }

    @Test
    void testWriteFile() throws IOException, NoSuchAlgorithmException {
        File f = new File ("example.txt");
        f.createNewFile();
        Blob bob = new Blob ("example.txt");
        bob.writeFile();

        File file_junit1 = new File("objects/" + bob.getShaString());
        assertTrue("Blob file to add not found", file_junit1.exists());

        File index_junit = new File ("index");
        assertTrue("Blob file to add not found", index_junit.exists());
    }
}
