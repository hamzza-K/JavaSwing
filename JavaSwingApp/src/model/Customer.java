package model;

import java.io.Serializable;

public class Customer implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int count = 0;
    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmployementCategory empCat;
    private String nicId;
    private boolean pakistani;
    private Gender gender;

    public Customer(String name, String occupation, AgeCategory ageCategory, EmployementCategory employementCategory,
            String nicId, boolean pakistani, Gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCat = employementCategory;
        this.nicId = nicId;
        this.pakistani = pakistani;
        this.gender = gender;
        this.id = count++;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the ageCategory
     */
    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    /**
     * @param ageCategory the ageCategory to set
     */
    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    /**
     * @return the empCat
     */
    public EmployementCategory getEmpCat() {
        return empCat;
    }

    /**
     * @param empCat the empCat to set
     */
    public void setEmpCat(EmployementCategory empCat) {
        this.empCat = empCat;
    }

    /**
     * @return the nicId
     */
    public String getNicId() {
        return nicId;
    }

    /**
     * @param nicId the nicId to set
     */
    public void setNicId(String nicId) {
        this.nicId = nicId;
    }

    /**
     * @return the pakistani
     */
    public boolean isPakistani() {
        return pakistani;
    }

    /**
     * @param pakistani the pakistani to set
     */
    public void setPakistani(boolean pakistani) {
        this.pakistani = pakistani;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

}