/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author alu2017454
 */
public class Tree {
    
    private String codi;
    private double posicioX;
    private double posicioY;
    private double latitud;
    private double longitud;
    private String tipusElement;
    private String espaiVerd;
    private String adreca;
    private String alcada;
    private int catEspecieId;
    private String nomCientific;
    private String nomEsp;
    private String nomCat;
    private String categoriaArbrat;
    private double ampladaVorera;
    private String plantacioDT;
    private String tipAigua;
    private String tipReg;
    private String tipSuperf;
    private String tipSuport;
    private String cobertaEscocell;
    private String midaEscocell;
    private String voraEscocell;
    
    public Tree() {
        
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setPosicioX(double posicioX) {
        this.posicioX = posicioX;
    }

    public void setPosicioY(double posicioY) {
        this.posicioY = posicioY;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setTipusElement(String tipusElement) {
        this.tipusElement = tipusElement;
    }

    public void setEspaiVerd(String espaiVerd) {
        this.espaiVerd = espaiVerd;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public void setAlcada(String alcada) {
        this.alcada = alcada;
    }

    public void setCatEspecieId(int catEspecieId) {
        this.catEspecieId = catEspecieId;
    }

    public void setNomCientific(String nomCientific) {
        this.nomCientific = nomCientific;
    }

    public void setNomEsp(String nomEsp) {
        this.nomEsp = nomEsp;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public void setCategoriaArbrat(String categoriaArbrat) {
        this.categoriaArbrat = categoriaArbrat;
    }

    public void setAmpladaVorera(double ampladaVorera) {
        this.ampladaVorera = ampladaVorera;
    }

    public void setPlantacioDT(String plantacioDT) {
        this.plantacioDT = plantacioDT;
    }

    public void setTipAigua(String tipAigua) {
        this.tipAigua = tipAigua;
    }

    public void setTipReg(String tipReg) {
        this.tipReg = tipReg;
    }

    public void setTipSuperf(String tipSuperf) {
        this.tipSuperf = tipSuperf;
    }

    public void setTipSuport(String tipSuport) {
        this.tipSuport = tipSuport;
    }

    public void setCobertaEscocell(String cobertaEscocell) {
        this.cobertaEscocell = cobertaEscocell;
    }

    public void setMidaEscocell(String midaEscocell) {
        this.midaEscocell = midaEscocell;
    }

    public void setVoraEscocell(String voraEscocell) {
        this.voraEscocell = voraEscocell;
    }
    
    

    public String getCodi() {
        return codi;
    }

    public double getPosicioX() {
        return posicioX;
    }

    public double getPosicioY() {
        return posicioY;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getTipusElement() {
        return tipusElement;
    }

    public String getEspaiVerd() {
        return espaiVerd;
    }

    public String getAdreca() {
        return adreca;
    }

    public String getAlcada() {
        return alcada;
    }

    public int getCatEspecieId() {
        return catEspecieId;
    }

    public String getNomCientific() {
        return nomCientific;
    }

    public String getNomEsp() {
        return nomEsp;
    }

    public String getNomCat() {
        return nomCat;
    }

    public String getCategoriaArbrat() {
        return categoriaArbrat;
    }

    public double getAmpladaVorera() {
        return ampladaVorera;
    }

    public String getPlantacioDT() {
        return plantacioDT;
    }

    public String getTipAigua() {
        return tipAigua;
    }

    public String getTipReg() {
        return tipReg;
    }

    public String getTipSuperf() {
        return tipSuperf;
    }

    public String getTipSuport() {
        return tipSuport;
    }

    public String getCobertaEscocell() {
        return cobertaEscocell;
    }

    public String getMidaEscocell() {
        return midaEscocell;
    }

    public String getVoraEscocell() {
        return voraEscocell;
    }

   
    

    @Override
    public String toString() {
        
        return getCodi() + " - " + getPosicioX() + " - " + getPosicioY() + " - " + getLatitud() + " - " +
                getLongitud() + " - " + getTipusElement() + " - " + getEspaiVerd() + " - " + getAdreca() + " - " +
                getAlcada() + " - " + getCatEspecieId() + " - " + getNomCientific() + " - " + getNomEsp() + " - " +
                getNomCat() + " - " + getCategoriaArbrat() + " - " + getAmpladaVorera() + " - " + getPlantacioDT() + " - " +
                getTipAigua() + " - " + getTipReg() + " - " + getTipSuperf() + " - " + getTipSuport() + " - " +
                getCobertaEscocell() + " - " + getMidaEscocell() + " - " + getVoraEscocell();
    }
    
    

    
}
