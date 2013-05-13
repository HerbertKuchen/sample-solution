package de.java.web;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import de.java.domain.ReplenishmentOrder;
import de.java.ejb.ReplenishmentOrderService;
import de.java.web.util.Util;

@ManagedBean
@ViewScoped
public class ReplenishmentOrderPage {

  @EJB
  private ReplenishmentOrderService orderService;

  private long id;

  private ReplenishmentOrder order;

  private Date expectedDelivery;
  private Date actualDelivery;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
    init();
  }

  public void init() {
    order = null;
    setExpectedDelivery(new Date());
    setActualDelivery(new Date());
  }

  public void ensureInitialized(){
    try{
      if(getOrder() != null)
        // Success
        return;
    } catch(EJBException e) {
      e.printStackTrace();
    }
    Util.redirectToRoot();
  }

  public ReplenishmentOrder getOrder() {
    if (order == null) {
      order = orderService.getOrder(id);
    }
    return order;
  }

  public String proceed() {
    orderService.proceedToNextState(order.getId());
    init();
    return returnToOrderPage();
  }

  private String returnToOrderPage() {
    return "/replenishmentOrder/details.xhtml?faces-redirect=true&id=" + id;
  }

  public String cancel() {
    orderService.cancel(order.getId());
    init();
    return returnToOrderPage();
  }

  public void setOrder(ReplenishmentOrder order) {
    this.order = order;
  }

  public Date getExpectedDelivery() {
    return expectedDelivery;
  }

  public void setExpectedDelivery(Date expectedDelivery) {
    this.expectedDelivery = expectedDelivery;
  }

  public Date getActualDelivery() {
    return actualDelivery;
  }

  public void setActualDelivery(Date actualDelivery) {
    this.actualDelivery = actualDelivery;
  }
}
