package coucheweb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.projet.metier.CatalogueMetierImp;
import org.projet.metier.ICatalogueMetier;
import org.projet.metier.Produit;
public class ControleurCatalogueServlet extends HttpServlet{
	private ICatalogueMetier metier;
	@Override
	public void init() throws ServletException {
		//creer une instance au demarrage
		metier= new  CatalogueMetierImp();
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		if(action!=null) {
		if(action.equals("Save")) {
			try {
			String des= req.getParameter("designation");
			double prix=Double.parseDouble(req.getParameter("prix"));
			int qte=Integer.parseInt(req.getParameter("quantite"));
			Produit P= new Produit(des,prix,qte);
			metier.addProduit(P);
			}catch(Exception e) {
				req.setAttribute("exception","saisie invalide" );
			}
		}
		else if (action.equals("supp")) {
			// recupere un parametre de suppression
			 Long id=Long.parseLong(req.getParameter("id"));
			 metier.deleteProduit(id);
		}
		else if (action.equals("Update")) {
			try {
			Long id=Long.parseLong(req.getParameter("idproduit"));
			String des= req.getParameter("designation");
			double prix=Double.parseDouble(req.getParameter("prix"));
			int qte=Integer.parseInt(req.getParameter("quantite"));
			Produit P= new Produit(des,prix,qte);
			P.setIdProduit(id);
			 metier.updateProduit(P);
			}catch(Exception e){
				e.printStackTrace();
				req.setAttribute("exception", "saisie invalide");
			}

		}
		
		else if (action.equals("edit")) {
			// recupere un parametre de suppression
			 Long id=Long.parseLong(req.getParameter("id"));
			 Produit p=metier.getProduit(id);
			// metier.updateProduit(metier.getProduit(id));
			 req.setAttribute("produit", p);
		}
		}
//permet de chaque si je recupere les donnees et la liste je revien a la page web
		//stocke un attribut dont la quell je stock une liste produit
		//lorque j'envoi la methode get il rammene la liste
		//set Attribut premt d'envoyer des donner au vue
		req.setAttribute("produits", metier.ListProduit());
		//lorsuq'on appel  forward de la servlet une page jsp est afficher
		req.getRequestDispatcher("Vues/produits.jsp").forward(req, resp);	
	}
	}
