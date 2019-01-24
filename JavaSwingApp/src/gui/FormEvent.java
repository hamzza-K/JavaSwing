package gui;

import java.util.EventObject;

public class FormEvent extends EventObject
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String occupation;
    private int ageCategory;
    private String empCat;
    private String nicId;
    private boolean pakistani;
    private String gender;


    
    public FormEvent(Object source)
    {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, int ageCat,
                     String empCat, String nicId, boolean pakistani, String gender) //communicates with formPanel's event
    {
        super(source);

        this.name = name; 
        this.occupation = occupation;
        this.ageCategory = ageCat;
        this.empCat = empCat;
        this.nicId = nicId;
        this.pakistani = pakistani;
        this.gender = gender;
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

    public int getAgeCategory()
    {
        return ageCategory;
    }

    public String getEmployementCategory()
    {
        return empCat;
    }

    /**
     * @param ageCategory the ageCategory to set
     */
    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    /**
     * @return the empCat
     */
    public String getEmpCat() {
        return empCat;
    }

    /**
     * @param empCat the empCat to set
     */
    public void setEmpCat(String empCat) {
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
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }


}