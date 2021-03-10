/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import DataStorage.MyDB;
import Entities.Evaluation;
import IServices.IEvaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class EvaluationService implements IEvaluation{
    Connection connexion;
    PreparedStatement ps;

    public EvaluationService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public boolean ajouterEvaluation(Evaluation e) {
        try {

            String req = "INSERT INTO `evaluation`(`id`,`id_produit`, `id_user`, `note`) VALUES ( ?,?,?,?)";                                              
            ps = connexion.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.setInt(2, e.getId_Produit());
            ps.setInt(3, e.getId_User());
            ps.setInt(4, e.getNote());

            if(ps.executeUpdate() == 1){
                System.out.println("Ajout effectué");
                return true;
            }else{
                System.out.println("Echec d'ajout");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec d'ajout");
            return false;
        }
    }
    @Override
    public boolean modifierEvaluation(Evaluation e) {
        try {
            String req = "UPDATE evaluation SET  note=? WHERE id=? and id_produit =? and id_user=?";
            ps = connexion.prepareStatement(req);
            ps.setInt(1, e.getNote());
            ps.setInt(2, e.getId());
            ps.setInt(3, e.getId_Produit());
            ps.setInt(4, e.getId_User());
            if(ps.executeUpdate() == 1){
                System.out.println("Modification effectué");
                return true;
            }else{
                System.out.println("Echec de Modification");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Echec de modification");
            return false;
        }
    }
    @Override
    public boolean supprimerEvaluation(int id) {
        try {
            String req = " DELETE FROM `evaluation` WHERE id = " + id + "";
            ps = connexion.prepareStatement(req);
            if(ps.executeUpdate() == 1){
                System.out.println("La supression du produit est effectuée");
                return true;
            }else{
                System.out.println("Echec de supression");
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Echec de supression");
        }
        return false;
    }
     @Override
    public Evaluation chercherEvaluationParID(int id) {
        Evaluation evaluation = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM evaluation WHERE id = " + id);
            if (result.first()) {

                evaluation = new Evaluation(result.getInt("id"), result.getInt("id_produit"), result.getInt("id_user"),result.getInt("note"));
                return evaluation;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return evaluation;
    }
    
    public Evaluation chercherEvaluationParIDProduit(int id) {
        Evaluation evaluation = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM evaluation WHERE id_produit = " + id);
            if (result.first()) {

                evaluation = new Evaluation(result.getInt("id"), result.getInt("id_produit"), result.getInt("id_user"),result.getInt("note"));
                return evaluation;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return evaluation;
    }
    public Evaluation chercherEvaluationParIDUser(int id) {
        Evaluation evaluation = null;
        try {
            ResultSet result = connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM evaluation WHERE id_user = " + id);
            if (result.first()) {

                evaluation = new Evaluation(result.getInt("id"), result.getInt("id_produit"), result.getInt("id_user"),result.getInt("note"));
                return evaluation;
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return evaluation;
    }
    
    @Override
    public List<Evaluation> listeEvaluation() {
        List<Evaluation> evaluations = new ArrayList();
        try {
            String req = "SELECT * FROM evaluation";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evaluation e = new Evaluation();
                e.setId(rs.getInt("id"));
                e.setId_Produit(rs.getInt("id_produit"));
                e.setId_User(rs.getInt("id_user"));
                e.setNote(rs.getInt("note"));
                evaluations.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return evaluations;
    }
    @Override
    public List<Evaluation> listeEvaluationParIdProduit(int id_produit) {
        List<Evaluation> evaluations = new ArrayList();
        try {
            String req = "SELECT * FROM evaluation where id_produit='"+id_produit+"'";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evaluation e = new Evaluation();
                e.setId(rs.getInt("id"));
                e.setId_Produit(rs.getInt("id_produit"));
                e.setId_User(rs.getInt("id_user"));
                e.setNote(rs.getInt("note"));
                evaluations.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return evaluations;
    }
    public List<Evaluation> listeEvaluationParIdUser(int id_user) {
        List<Evaluation> evaluations = new ArrayList();
        try {
            String req = "SELECT * FROM evaluation where id_user='"+id_user+"'";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evaluation e = new Evaluation();
                e.setId(rs.getInt("id"));
                e.setId_Produit(rs.getInt("id_produit"));
                e.setId_User(rs.getInt("id_user"));
                e.setNote(rs.getInt("note"));
                evaluations.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Echec");
        }
        return evaluations;
    }
    @Override
    public String getNextId() {
        String nextid = "";
        try {
            String req = "SHOW TABLE STATUS LIKE 'evaluation'";
            ps = connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nextid = rs.getString("Auto_increment");
            }
        } catch (SQLException ex) {
            System.out.println("Echec get Next ID ");
        }
        return nextid;
    }
}