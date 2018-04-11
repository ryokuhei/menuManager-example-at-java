package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.mycompany.menuManager.MenuList;
import com.mycompany.menuManager.MenuModel;
import com.mycompany.menuManager.Presenter;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.Model;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	private Model<String> keyModel = new Model<String>();
	private Model<String> displayModel = new Model<String>();

	private Model<String> beforeKeyModel = new Model<String>();
	private Model<String> beforeDisplayModel = new Model<String>();

	private Model<String> afterKeyModel = new Model<String>();
	private Model<String> afterDisplayModel = new Model<String>();


    private Presenter presenter;
	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		this.presenter = new Presenter();
		MenuModel menu = this.presenter.currentMenu();
		keyModel.setObject(menu.getKey());
		displayModel.setObject(menu.getDisplay());

		this.setBeforeModel();
		this.setAfterModel();


		
		Form form = new Form("form");
		this.add(form);

		form.add(new Label("beforeKey", this.beforeKeyModel));
		form.add(new Label("beforeDisplay", this.beforeDisplayModel));

		form.add(new Label("currentKey", this.keyModel));
		form.add(new Label("currentDisplay", this.displayModel));

    	form.add(new Label("afterKey", this.afterKeyModel));
		form.add(new Label("afterDisplay", this.afterDisplayModel));
		
		Button prev = new Button("prev") {
			@Override
			public void onSubmit() {
				MenuModel menu = presenter.previous();
				keyModel.setObject(menu.getKey());
				displayModel.setObject(menu.getDisplay());

    		    setBeforeModel();
		        setAfterModel();
			}
		};
		form.add(prev);

		Button next = new Button("next") {
			@Override
			public void onSubmit() {

		System.out.println("参照値:" + presenter.hashCode());
				MenuModel menu = presenter.next();
				keyModel.setObject(menu.getKey());
				displayModel.setObject(menu.getDisplay());

    		    setBeforeModel();
		        setAfterModel();
			}
		};
		form.add(next);

    }
	
	private void setBeforeModel() {
    	MenuModel beforeMenu = this.presenter.beforeMenu();
		if(beforeMenu != null) {
			this.beforeKeyModel.setObject(beforeMenu.getKey());
			this.beforeDisplayModel.setObject(beforeMenu.getDisplay());
		}
	}

	private void setAfterModel() {
		MenuModel afterMenu = this.presenter.afterMenu();
		if(afterMenu != null) {
		    this.afterKeyModel.setObject(afterMenu.getKey());
			this.afterDisplayModel.setObject(afterMenu.getDisplay());
		}
	}
}
