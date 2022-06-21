package net.alexanderandrade.api.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

  private FileUtil() {
    // Empty constructor with commentary suggested by SonarQube's code smells
  }

  public static String readPlainText(String filePath) throws IOException {
    String contents = null;
    try {
      contents = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      throw new IOException("Cannot open file '" + filePath, e);
    }

    return contents;
  }

}
