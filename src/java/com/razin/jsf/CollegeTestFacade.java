/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.razin.jsf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author razintailor
 */
@Stateless
public class CollegeTestFacade extends AbstractFacade<CollegeTest> {

    @PersistenceContext(unitName = "jsf_college_trialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CollegeTestFacade() {
        super(CollegeTest.class);
    }
    
}
