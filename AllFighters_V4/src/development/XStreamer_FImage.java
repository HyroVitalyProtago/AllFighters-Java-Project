/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.objects.FImage;

/**
 *
 * @author MyMac
 */
public class XStreamer_FImage extends XStreamer<FImage> {

    public XStreamer_FImage() {
        this.alias("FImage", FImage.class);
    }

    @Override
    protected void make(FImage e) {
        try {
            e.makeBufferedImg();
        } catch (IOException ex) {
            Logger.getLogger(XStreamer_FImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
