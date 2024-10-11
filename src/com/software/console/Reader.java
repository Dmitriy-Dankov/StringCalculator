package com.software.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.software.functions.Functions;

public class Reader {
    private BufferedReader br;

    public BufferedReader getBufferedReader() {
        return br;
    }

    public void setBufferedReader(BufferedReader br) {
        this.br = br;
    }

    public void openStreamIn() {
        br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));
    }

    public void closeStreamIn() throws IOException {
        if (br != null) {
            br.close();
            br = null;
        }
    }

    public char readChar() throws IOException {
        skipSpaces();
        return (char) br.read();
    }

    public String readLine() throws IOException {
        skipSpaces();
        return br.readLine();
    }

    public String readWord() throws IOException {
        skipSpaces();
        StringBuilder strBuff = new StringBuilder();
        Character temp;

        while ((temp = (char) br.read()) != null) {
            if (temp == '"') {
                strBuff.append(temp);
                while ((temp = (char) br.read()) != '"') {
                    if(temp == '\n' || temp == '\r') break; 
                    strBuff.append(temp);
                }
            }

            if (Functions.isDigit(temp) || Character.isWhitespace(temp))
                break;
            else
                strBuff.append(temp);
        }

        return strBuff.toString();
    }

    public List<String> readArrStrings() throws IOException {
        List<String> arr = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            arr.add(line);
        }
        return arr;
    }

    public Integer readInteger() throws IOException {
        skipSpaces();
        StringBuilder strBuff = new StringBuilder();
        Character temp;

        while ((temp = (char) br.read()) != null) {
            if (!Functions.isDigit(temp))
                break;
            else
                strBuff.append(temp);
        }

        return Integer.valueOf(strBuff.toString());
    }

    public Double readDouble() throws IOException {
        skipSpaces();
        StringBuilder strBuff = new StringBuilder();
        Character temp;
        boolean hasPoint = false;

        while ((temp = (char) br.read()) != null) {
            if (Functions.isDigit(temp)) {
                strBuff.append(temp);

            } else if (temp == '.' && !hasPoint) {
                hasPoint = true;
                temp = (char) br.read();
                if (Functions.isDigit(temp)) {
                    strBuff.append('.');
                    strBuff.append(temp);
                } else {
                    break;
                }
            } else
                break;
        }

        return Double.valueOf(strBuff.toString());
    }

    private void skipSpaces() throws IOException {
        do {
            br.mark(1);
        } while(Character.isWhitespace(br.read()));

        br.reset();
    }
}
