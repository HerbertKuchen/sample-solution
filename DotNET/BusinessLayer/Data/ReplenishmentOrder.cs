//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Pharmacy.BusinessLayer.Data
{
    using System;
    using System.Collections.Generic;
    
    public partial class ReplenishmentOrder
    {
        public ReplenishmentOrder()
        {
            this.Positions = new HashSet<Position>();
        }
    
        public int Id { get; set; }
        public Pharmacy.BusinessLayer.Data.OrderState State { get; set; }
        public Nullable<System.DateTime> ExpectedDelivery { get; set; }
        public Nullable<System.DateTime> ActualDelivery { get; set; }
    
        public virtual ICollection<Position> Positions { get; set; }
    }
}
