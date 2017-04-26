package fr.lmarchau.saxinova;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import fr.lmarchau.saxinova.model.Contact;
import fr.lmarchau.saxinova.printer.ContactPrinter;
import fr.lmarchau.saxinova.sax.XmlContactParser;
import fr.lmarchau.saxinova.utils.CommandLineParser;
import fr.lmarchau.saxinova.utils.Usage;

public class Saxinova {

    private static final Logger LOG = Logger.getGlobal();

    public static void main(String[] args) {
        // extract and check file from command line args
        File file = null;
        try {
            file = CommandLineParser.extractFileFromArgs(args);
        } catch (IllegalArgumentException|FileNotFoundException e) {
            Usage.usage();
        }

        // parse xml file
        XmlContactParser contactParser = new XmlContactParser();
        List<Contact> contacts = null;
        try {
            contacts = contactParser.parse(file);
        } catch (ParserConfigurationException|IOException e) {
            LOG.severe(e.toString());
            System.exit(1);
        } catch (SAXException e) {
            LOG.info("Exit with status 1");
            System.exit(1);
        }

        // print results
        ContactPrinter.print(contacts);
    }
}
