package wordfinder.wordfinder;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DictionaryReader {
    private BufferedReader reader;
    private String filename;

    public DictionaryReader(String filename) {
        this.filename = filename;
    }

    private BufferedReader openAsset() {
        try {
            Resources myRes = MainWindow.resources;
            InputStream is = MainWindow.resources.getAssets().open(filename);
            return new BufferedReader(new InputStreamReader(is));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean openFile() {
        reader = openAsset();
        if (reader != null) {
            return true;
        }
        try {
            reader = new BufferedReader(new FileReader(filename));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeFile() {
        try {
            reader.close();
        } catch (Exception e) {
            //I dont give a fuck!
        }
    }

    public String getEntry() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }
}