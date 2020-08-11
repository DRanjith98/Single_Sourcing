package com.ltts.example.commands;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
 
public class AboutDialog extends Dialog {
 
   private static final long serialVersionUID = -1969407778775319986L;
    
   protected Object result;
   protected Shell shlAbout;
 
   /**
    * Create the dialog.
    * @param parent
    * @param style
    */
   public AboutDialog(Shell parent, int style) {
       super(parent, style);
       setText("SWT Dialog");
   }
 
   /**
    * Open the dialog.
    * @return the result
    */
   public Object open() {
       createContents();
       shlAbout.open();
       shlAbout.layout();
       Display display = getParent().getDisplay();
       while (!shlAbout.isDisposed()) {
           if (!display.readAndDispatch()) {
               display.sleep();
           }
       }
       return result;
   }
 
   /**
    * Create contents of the dialog.
    */
   private void createContents() {
       shlAbout = new Shell(getParent(), getStyle());
       shlAbout.setSize(418, 200);
       shlAbout.setText("About");
       shlAbout.setLocation(770, 400);
       shlAbout.setLayout(new GridLayout(1, false));
        
       Label lblNewLabel = new Label(shlAbout, SWT.NONE);
       lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
       lblNewLabel.setText(" RAP Example ");
 
   }
 
}
