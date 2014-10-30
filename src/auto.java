import java.applet.*;
import java.awt.*;
import java.awt.image.*;

public class auto extends Applet{

	Image img;
	int w = 400;
	int h = 400;
	
	int pix[] = new int[w*h];
	IndexColorModel cm;
	
	public void init(){
		byte[] r = {(byte)0x99,(byte)0x00};
		byte[] g = {(byte)0x99,(byte)0x00};
		byte[] b = {(byte)0x99,(byte)0xff};
		
		cm = new IndexColorModel(8,2,r,g,b);
		
		setPix();
	}

	public void setPix() {
		
		pix[w/2] = 1;
		
		for(int y=1;y<h;y++){
			if(y < h/2){
			for(int x=1;x<w;x++){
				int p = y*w+x;
				if(x < w/2)
					pix[p] = 1;	
					
				/*
				pix[p] = pix[p-w-1]+pix[p-w+1];
				if(pix[p] == 1){
					pix[p] = 1;
				}else{
					pix[p] = 0;
				}
				}*/
				
			}	
			}else{
				for(int x=1;x<w;x++){
					int p = y*w+x;
					if(x < w/2){
						pix[p] = 0;	
					}else{
						pix[p] = 1;	
					}
				}
			}
		}
		
	}

	public void paint(Graphics g){
		MemoryImageSource mimg = new MemoryImageSource(w,h,cm,pix,0,w);
		
		img = createImage(mimg);
		
		g.drawImage(img, 0, 0, this);
		
	}
}
