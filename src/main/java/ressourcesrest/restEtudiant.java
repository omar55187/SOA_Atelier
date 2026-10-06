package ressourcesrest;

import entities.Etudiant;
import metiers.EtudiantBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("etudiants")
public class restEtudiant {
    public EtudiantBusiness etudiantB = new EtudiantBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEtudiants(){
        List<Etudiant> l = etudiantB.getAllEtudiants();
        return Response.status(200).entity(l).build();
    }

    @GET
    @Path("{identifiant}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEtudiantByIdentifiant(@PathParam("identifiant") String identifiant) {
        Etudiant etudiant = etudiantB.getEtudiantByIdentifiant(identifiant);
        if (etudiant != null) {
            return Response.status(200).entity(etudiant).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Étudiant non trouvé").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEtudiant(Etudiant etudiant) {
        if (etudiantB.addEtudiant(etudiant)) {
            return Response.status(Response.Status.CREATED).entity(etudiant).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Erreur lors de l'ajout (Option invalide)").build();
    }

    @PUT
    @Path("{identifiant}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEtudiant(@PathParam("identifiant") String identifiant, Etudiant updatedEtudiant) {
        if (etudiantB.updateEtudiant(identifiant, updatedEtudiant)) {
            return Response.status(200).entity(updatedEtudiant).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Étudiant introuvable").build();
    }

    @DELETE
    @Path("{identifiant}")
    public Response deleteEtudiant(@PathParam("identifiant") String identifiant) {
        if (etudiantB.deleteEtudiant(identifiant)) {
            return Response.status(200).entity("Étudiant supprimé avec succès").build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Étudiant non trouvé").build();
    }}
# 1. Mettre à jour l'URL du dépôt distant
git remote set-url origin https://github.com/omar55187/SOA_Atelier.git

        # 2. Si origin n'était pas encore configuré, lancez plutôt :
        # git remote add origin https://github.com/omar55187/SOA_Atelier.git

        # 3. Ajouter tous les fichiers modifiés et créer le commit
git add .
git commit -m "Ajout du projet REST Gestion_UE_VF complet"

        # 4. Définir la branche principale sur main
git branch -M main

# 5. Pousser le code vers le nouveau repository
git push -u origin main