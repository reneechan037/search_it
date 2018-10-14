package Controller;

import java.util.Scanner;

public interface Command {
    public void execute(String[] cmdParts);
}