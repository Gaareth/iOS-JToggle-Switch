package iOS.jtoggle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;


/**
* <h1>A Custom JToggleButton with an iOS Inspired Style</h1>
*
* @author  Gareth
* @version 1.0.
* @since   2019-03-11 
*/
public class iOS_ToggleButton extends JToggleButton implements MouseListener{
	
	private int x, y, width, height;
	
	private boolean filled = true;
	private boolean state = true;
	private boolean autosize = false;
	private int ovalsize = 6;
	
	private Color backgroundColor = state ? new Color(110, 220, 95) : new Color(221, 221, 221);

	
	
	public iOS_ToggleButton() {
		setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new LineBorder(Color.LIGHT_GRAY, 0, true));
        addMouseListener(this);
        setVisible(true);
	}		
	
	
	
	/**
	 * @param autosize Parameter for autosizing the height value.
	 */
	public iOS_ToggleButton(boolean autosize) {
		this();
		this.autosize = autosize;
	}
	
	/**
	 * @param ovalvar Parameter for setting the size of the oval. Smaller -> Bigger Oval Size.
	 */
	public iOS_ToggleButton(int ovalvar) {
		this();
		this.ovalsize = ovalvar;
	}
	
	/**
	 * @param ovalsize Parameter for setting the size of the oval. Smaller -> Bigger Oval Size.
	 * @param autosize Parameter for autosizing the height value.
	 */
	public iOS_ToggleButton(int ovalsize, boolean autosize) {
		this();
		this.ovalsize = ovalsize;
		this.autosize = autosize;
		System.out.println(ovalsize);
	}

	
	/**
	 * @return returns the value of the autoSize boolean.
	 */
	public boolean isAutosize() {
		return autosize;
	}
	
	/**
	 * @param autosize The Autosizing boolean for adjusting the height.
	 */
	public void setAutosize(boolean autosize) {
		this.autosize = autosize;
	}


	/**
	 * @return returns the current ovalvar
	 */
	public int getOvalsize() {
		return ovalsize;
	}

	/**
	 * @param ovalsize Setting the ovalvar corresponding the ovalsize. Smaller -> Bigger Oval Size.
	 */
	void setOvalsize(int ovalsize) {
		this.ovalsize = ovalsize;
	}

	
	public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e){
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    	toggleState();
    	repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }

	/**
	 * Function for toggling the current state of the ToggleButton.
	 */
	public void toggleState() {
		if(state) {
			state = false;
			setSelected(false);
		}else {
			state = true;
			setSelected(true);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.Component#setBounds(int, int, int, int)
	 */
	@Override
	public void setBounds(int x, int y, int width, int height) {
	    super.setBounds(x, y, width, height);
		this.x = 0;
		this.y = 0;
		this.width = width-50;
		if(autosize == true)
			this.height = this.width-10;
		else
			this.height = height;
	}
	

	
	/* Overriding the paintComponent function.
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);       
        backgroundColor = state ? new Color(110, 220, 95) : new Color(221, 221, 221);
        Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Smooth Edegs
        g2.setStroke(new BasicStroke(3.0f));
        
        Shape halfCircle = new Arc2D.Double(x, y, width, height, 90, 180, Arc2D.OPEN); // First Semi Circle: (
        
        Shape halfCircle2 = new Arc2D.Double(x+width/2-5, y, width, height, 90, -180, Arc2D.CHORD); //Second Semi Circle: )
        
        g2.setPaint(backgroundColor);
        

        g2.fill(halfCircle);
        g2.fill(halfCircle2);
        
        if(!filled) {
        	Line2D lin = new Line2D.Float(x, y, x+50, y);
            
        	Line2D lin2 = new Line2D.Float(x, y+height, x+50, y+height);
        	g2.draw(lin);
        	g2.draw(lin2);
        }else {
        	 g.fillRect(x+width/2, y, width/2+1, height); //Rectangle for filling the gap between the Arcs.
        }
        
        
        
        g2.setPaint(Color.WHITE);
        if(state) {
        	g.fillOval(x+width/2+ovalsize+2, y+(ovalsize/2), height-ovalsize, height-ovalsize); // White circle. Adjust it for the position of the circle.
        }else {
        	g.fillOval(x+ovalsize/2, y+ovalsize/2, height-ovalsize, height-ovalsize); 
        }
	        
    }
}
