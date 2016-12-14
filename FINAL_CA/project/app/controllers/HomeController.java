package controllers;

import controllers.security.AuthAdmin;
import controllers.security.Secured;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

// Import models
import models.*;
import models.users.*;


public class HomeController extends Controller {

    // Declare a private FormFactory instance
    private FormFactory formFactory;

    //  Inject an instance of FormFactory it into the controller via its constructor
    @Inject
    public HomeController(FormFactory f) {
        this.formFactory = f;
    }

    // Method retuns the logged in user (or null)
    private User getUserFromSession() {
        return User.getUserById(session().get("email"));
    }

        public Result index() {
        return ok(index.render());
    }

    public Result guitars() {
	     return ok(guitars.render());
    }

    public Result drums() {
	     return ok(drums.render());
    }

    public Result keyboards() {
	     return ok(keyboards.render());
    }

    public Result amps() {
	     return ok(amps.render());
    }

    public Result mics() {
	     return ok(mics.render());
    }

    public Result lighting() {
	     return ok(lighting.render());
    }

    public Result events() {
	     return ok(events.render());
    }

    public Result contact() {
	     return ok(contact.render());
    }



    public Result products(Long cat) {

        // Get list of all categories in ascending order
        List<Category> categoriesList = Category.findAll();
        List<Product> productsList = new ArrayList<Product>();

        if (cat == 0) {
            // Get list of all categories in ascending order
            productsList = Product.findAll();
        }
        else {
            // Get products for selected category
            // Find category first then extract products for that cat.
            productsList = Category.find.ref(cat).getProducts();
        }

        return ok(products.render(productsList, categoriesList, getUserFromSession()));
    }

        public Result addProduct() {

        // Create a form by wrapping the Product class
        // in a FormFactory form instance
        Form<Product> addProductForm = formFactory.form(Product.class);

        // Render the Add Product View, passing the form object   
        return ok(addProduct.render(addProductForm));
    }

    public Result addProductSubmit() {

        // Create a product form object (to hold submitted data)
        // 'Bind' the object to the submitted form (this copies the filled form)
        Form<Product> newProductForm = formFactory.form(Product.class).bindFromRequest();

        // Check for errors (based on Product class annotations)
        if(newProductForm.hasErrors()) {
            // Display the form again
            return badRequest(addProduct.render(newProductForm));
        }

        // Extract the product from the form object
        Product newProduct = newProductForm.get();

        // Save to the database via Ebean (remember Product extends Model)
        newProduct.save();

        flash("success", "Product " + newProduct.getName() + " has been created");


        Product p = newProductForm.get();

        if (p.getId() == null) {
            p.save();
        }

        else if (p.getId() != null) {
            p.update();
        }

        // Set a success message in temporary flash
        // for display in return view
         flash("success", "Product " + newProduct.getName() + " has been created/updated");

        // Redirect to the admin home
        return redirect(controllers.routes.HomeController.products(0));


    }
}
