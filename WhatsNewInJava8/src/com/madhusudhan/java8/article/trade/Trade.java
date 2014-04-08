package com.madhusudhan.java8.article.trade;

/**
 *
 * @author mkonda
 */
public class Trade {

    private int tradeId = 0;
    private String issuer = null;
    private int quantity = 0;
    private String status = null;

    public Trade(int id, String issuer, int quantity, String status) {
        this.tradeId = id;
        this.issuer = issuer;
        this.quantity = quantity;
        this.status = status;
    }

    public Trade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Trade{" + "tradeId=" + tradeId + ", issuer=" + issuer + ", quantity=" + quantity + ", status=" + status + '}';
    }

}
