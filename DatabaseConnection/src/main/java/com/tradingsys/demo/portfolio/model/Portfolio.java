package com.tradingsys.demo.portfolio.model;

import com.tradingsys.demo.client.model.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="portfolio")
public class Portfolio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "portfolio_id")
    private Integer portfolioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;



//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "portfolio")
//    private List<ClientOrder> orders = new ArrayList<>();


    public Portfolio() {

    }


    public Portfolio(Integer portfolioId, Client client) {
        this.portfolioId = portfolioId;
        this.client = client;
    }

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
