package com.ltts.example.views;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class View_1_Handler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		 
	
		try {
	
			    HandlerUtil.getActiveWorkbenchWindow(event).getActivePage()
			    .showView("com.ltts.example.view_1");
			    } 
		 catch (PartInitException e) 
		 		{
			        throw new ExecutionException("Error while opening view", e);
			    }
			    return null;
	}

}
