package edu.uc.rel.t2t.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.*;

public class MethodsView extends ViewPart implements ISelectionListener{

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "t2t.views.MethodsView";
	
	/**
	 * The constructor.
	 */
	public MethodsView() {
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
parent.setLayout(new FormLayout());
		//Create tagging label
		Label tagLabel = new Label(parent,SWT.SINGLE);
		tagLabel.setText("Tags:");
		FormData fd = new FormData();
		fd.top = new FormAttachment(0,10);
		fd.left = new FormAttachment(0,10);
		tagLabel.setLayoutData(fd);
		
		//Create tagging text
		Text tagText = new Text(parent,SWT.SINGLE|SWT.BORDER);
		fd = new FormData();
		fd.top = new FormAttachment(0,10);
		fd.left = new FormAttachment(tagLabel,5);
		fd.right = new FormAttachment(tagLabel,190);
		tagText.setLayoutData(fd);
		
		//Create plus button
		Button plus = new Button(parent,SWT.PUSH);
		plus.setText("+");
		fd = new FormData();
		fd.top = new FormAttachment(0,5);
		fd.left = new FormAttachment(tagText,10);
		plus.setLayoutData(fd);
		
		//Create minus button
		Button minus = new Button(parent,SWT.PUSH);
		minus.setText("-");
		fd = new FormData();
		fd.top = new FormAttachment(0,5);
		fd.left = new FormAttachment(plus,10);
		minus.setLayoutData(fd);
		
		//Create table
        Table table = new Table(parent,SWT.H_SCROLL|SWT.V_SCROLL|SWT.MULTI|SWT.FULL_SELECTION);
		
        //Set table columns
		TableColumn column1 = new TableColumn(table,SWT.CENTER);
		column1.setText("");
		column1.setWidth(20);
		
		TableColumn column2 = new TableColumn(table,SWT.LEFT);
		column2.setText("Method Name");
		column2.setWidth(200);
		
		TableColumn column3 = new TableColumn(table,SWT.LEFT);
		column3.setText("Tag( # of appearace in method): user-input weight=X");
		column3.setWidth(800);
		
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		//Create rows
		for(int i=0;i<10;i++){
			TableItem ti = new TableItem(table,SWT.NONE);
			TableEditor editor = new TableEditor(table);
			editor.grabHorizontal=true;
			Button chx = new Button(table,SWT.CHECK|SWT.CENTER);
			editor.setEditor(chx, ti, 0);
			ti.setText(1,"method"+i);
			ti.setText(2,"");
		}
		
		//Set table position
		fd = new FormData();
		fd.top = new FormAttachment(tagText,5);
		fd.bottom = new FormAttachment(tagText,240);
		fd.left = new FormAttachment(0,10);
		table.setLayoutData(fd);
		
		//Create submit button
		Button submit = new Button(parent,SWT.PUSH);
 		submit.setText("SUBMIT");
		fd = new FormData();
		fd.top = new FormAttachment(table,5);
		fd.left = new FormAttachment(0,860);
		submit.setLayoutData(fd);
	}
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

}
