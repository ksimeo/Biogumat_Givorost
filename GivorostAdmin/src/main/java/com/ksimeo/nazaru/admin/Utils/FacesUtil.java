//package com.ksimeo.nazaru.admin.Utils;
//
//import javax.faces.FactoryFinder;
//import javax.faces.component.UIViewRoot;
//import javax.faces.context.FacesContext;
//import javax.faces.context.FacesContextFactory;
//import javax.faces.lifecycle.Lifecycle;
//import javax.faces.lifecycle.LifecycleFactory;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
//* Created by @Ksimeo on 30.10.14.
//*/
//public class FacesUtil {
//
//    public static FacesContext getFacesContext(HttpServletRequest request, HttpServletResponse response)
//    {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//
//        if (facesContext == null) {
//
//            LifecycleFactory lifecycleFactory = (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
//            Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
//
//            // Create new FacesContext.
//            FacesContextFactory contextFactory  = (FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
//            facesContext = contextFactory.getFacesContext(request.getSession().getServletContext(), request, response, lifecycle);
//
//            // Create new View.
//            UIViewRoot admin = facesContext.getApplication().getViewHandler().createView(facesContext, "");
//            facesContext.setViewRoot(admin);
//
//            // Set current FacesContext.
//            FacesContextWrapper.setCurrentInstance(facesContext);
//        }
//
//        return facesContext;
//    }
//
//    // Wrap the protected FacesContext.setCurrentInstance() in a inner class.
//    private static abstract class FacesContextWrapper extends FacesContext
//    {
//        protected static void setCurrentInstance(FacesContext facesContext)
//        {
//            FacesContext.setCurrentInstance(facesContext);
//        }
//    }
//}