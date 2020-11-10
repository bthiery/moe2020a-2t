package com.hellokoding.springboot;

import com.hellokoding.ihm.AlerteForm;
import com.hellokoding.ihm.AlerteLine;
import com.hellokoding.ihm.PersonForm;
import com.hellokoding.ihm.PersonLine;
import com.hellokoding.persistance.txnscript;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AlerteController {

  Logger logger = LoggerFactory.getLogger(AlerteController.class);

  private static List<AlerteLine> alertes_table = new ArrayList<AlerteLine>();

  txnscript txn = new txnscript() ;

  // @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET) // 2019
  @GetMapping( { "/", "/index" } ) // 2020
  public String index(Model model) throws Exception {

    if (alertes_table.size() == 0) {
      ResultSet rs_alertes = txn.remonterEnRAlertes() ;

      logger.info(" liste alertes : initialized");

      while (rs_alertes.next()) {
        String type = rs_alertes.getString("type");
        String contenu = rs_alertes.getString("contenu");
        Boolean actif = rs_alertes.getBoolean("actif");

        alertes_table.add(new AlerteLine(type, contenu, actif));

        logger.info("alerte contenu : "+ contenu);
      }
    }

    AlerteForm af = new AlerteForm();
    model.addAttribute("travauxForm", af);

    model.addAttribute("alertes_tables", alertes_table);

    return "index";
  }

  @RequestMapping(value = { "/ajouterTravaux" }, method = RequestMethod.POST)
  public String saveTravaux(Model model, //
                           @ModelAttribute("AlerteForm") AlerteForm travauxForm) {

    String contenu = travauxForm.getContenu();

    logger.info("contenu a ajouter : "+contenu);

    if (contenu != null && contenu.length() > 0){
      AlerteLine newTravauxLine = new AlerteLine("Travaux", contenu, true);
      alertes_table.add(newTravauxLine);
      logger.info("travaux ajoute comme y faut : "+ contenu);

      return "redirect:";
    }

    logger.info("probleme pendant ajout du travaux");
    return "redirect:";
  }

}
