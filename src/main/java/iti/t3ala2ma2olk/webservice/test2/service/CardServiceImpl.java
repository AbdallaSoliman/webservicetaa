package iti.t3ala2ma2olk.webservice.test2.service;

import iti.t3ala2ma2olk.webservice.test2.dao.BaseballCardRepository;
import iti.t3ala2ma2olk.webservice.test2.model.BaseballCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CardServiceImpl implements CardService {

    @Autowired
    BaseballCardRepository cardrepository;

    BaseballCard TedWilliams = new BaseballCard();
    BaseballCard BobGibson = new BaseballCard();
    BaseballCard HonusWagner = new BaseballCard();

    public void addCards() {
        TedWilliams.setName("Ted Williams ff");
        TedWilliams.setYear(1954);
        TedWilliams.setRarityLevel("Very Rare ");

        cardrepository.save(TedWilliams);

        BobGibson.setName("Bob Gibson ff");
        BobGibson.setYear(1959);
        BobGibson.setRarityLevel("Very Rare");

        cardrepository.save(BobGibson);

        HonusWagner.setName("Honus Wagner qq");
        HonusWagner.setYear(1909);
        HonusWagner.setRarityLevel("Rarest");

        cardrepository.save(HonusWagner);

        System.out.println("Cards have been added : " + cardrepository.findAll());

    }
}
