package br.com.maverick.api.common.model;

public class CepAddress {

    private String cep;
    private String StreetName;
    private String complement;
    private String neighborhoodName;
    private String cityName;
    private String stateNick;

    public CepAddress() {
    }

    public CepAddress(String cep, String streetName, String complement, String neighborhoodName, String cityName, String stateNick) {
        this.cep = cep;
        StreetName = streetName;
        this.complement = complement;
        this.neighborhoodName = neighborhoodName;
        this.cityName = cityName;
        this.stateNick = stateNick;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateNick() {
        return stateNick;
    }

    public void setStateNick(String stateNick) {
        this.stateNick = stateNick;
    }
}
