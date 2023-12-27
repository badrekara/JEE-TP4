package org.sid.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.orderservice.model.Product;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductItem {//ADP
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @Transient
    private Product product;
    private double price;
    private int quantity; //quantite de produits dans la commande
    private double discount;
    @ManyToOne
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)//pour ne pas afficher ca (pour eviter les boucles infini)
    private Order order;

    public double getAmount(){
        return price*quantity*(1-discount);
    }
}
