package LegiestReyniers.control.services.impl;

import LegiestReyniers.model.Favorit;
import LegiestReyniers.repositories.FavoritRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class FavoritesServiceImpl {

    @Resource
    FavoritRepository favoritRepository;

    public void addToFavorites(String stationUri, int userId){
        Favorit favorit = new Favorit();
        favorit.setStation_uri(stationUri);
        favorit.setUserId(userId);
        favoritRepository.save(favorit);
    }


    public Iterable<Favorit> findByUserId(int userID) {

        Iterable<Favorit> allFavorit = favoritRepository.findAll();

        ArrayList<Favorit> favorits = new ArrayList<>();

        for(Favorit f: allFavorit){

            if(f.getUserId() == userID){
                favorits.add(f);
            }

        }

        Iterable<Favorit> complete = favorits;
        return complete;

    }
}
