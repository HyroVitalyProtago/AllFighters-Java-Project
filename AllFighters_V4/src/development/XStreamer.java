/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.*;

/**
 *
 * @author MyMac
 */
public abstract class XStreamer<E> {

    private XStream xstream;

    public XStreamer() {
        this.xstream = new XStream(new StaxDriver());
        xstream.autodetectAnnotations(true);
    }

    public void alias(String s, Class c) {
        this.xstream.alias(s, c);
    }

    public void save(E e, String location) {
        try {
            xstream.toXML(e, new FileWriter(location+".xml"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
    }

    public E load(String location) {
        /*
        String xml = "";
        try {
            InputStream ips = new FileInputStream(location);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
                xml += ligne + "\n";
            }            
            br.close();
            ipsr.close();
            ips.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }*/
        
        E e = (E) xstream.fromXML(new File(location+".xml"));
        
        make(e);
        
        return e;
    }
    
    protected abstract void make(E e);
    
    //Permet de l'utiliser aussi cpmme un xstream normal
    public String toXml(Object o) {
        return this.xstream.toXML(o);
    }
    public Object fromXML(String xml) {
        return this.xstream.fromXML(xml);
    }
    
}
