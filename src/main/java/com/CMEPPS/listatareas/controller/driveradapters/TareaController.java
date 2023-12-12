package com.CMEPPS.listatareas.controller.driveradapters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CMEPPS.listatareas.model.application.EstadoTarea;
import com.CMEPPS.listatareas.model.application.Tarea;
import com.CMEPPS.listatareas.service.driverport.ITareaService;

@Controller
public class TareaController {
	
	private int tipo = 1;
	
    @Autowired
    private ITareaService tareaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        model.put("todos", tareaService.getTodos());
        return "list-todos";
    }
    
    @RequestMapping(value = "/terminadas-todos", method = RequestMethod.GET)
    public String showTTodos(ModelMap model) {
        model.put("todos", tareaService.getTodos());
        return "listT-todos";
    }
    
    @RequestMapping(value = "/filtrar-todo", method = RequestMethod.GET)
    public String searchFiltrar(ModelMap model) {
    	model.addAttribute("todo", new Tarea());
        return "filtro-todos";
    }
    
    @RequestMapping(value = "/filtrar-todo", method = RequestMethod.POST)
    public String showFiltrar(ModelMap model, @Validated Tarea tarea, BindingResult result) {
    	
    	if (result.hasErrors()) {
            return "filtro-todos";
        }
    	
        model.put("todos", tareaService.getTodosFiltro(tarea.getPrioridad()));
        return "list-todos";
    }
    
    @RequestMapping(value = "/terminar-todo", method = RequestMethod.GET)
    public String todoTerminar(ModelMap model) {
    	model.addAttribute("filtroTodos", 1);
        return "filtro-todos";
    }
    
    @RequestMapping(value = "/terminar-todo", method = RequestMethod.POST)
    public String showTerminar(ModelMap model, @RequestParam("filtroTodos") @Validated int prioridad, BindingResult result) {
    	
    	if (result.hasErrors()) {
            return "filtro-todos";
        }
    	
        model.put("todos", tareaService.getTodosFiltro(prioridad));
        return "list-todos";
    }
    
    @RequestMapping(value = "/ordenar-todo", method = RequestMethod.GET)
    public String showOrdenar(ModelMap model) {
        model.put("todos", tareaService.getTodosOrdenar(tipo));
        if(tipo != 1) {
        	tipo = 1;
        }else {
        	tipo++;
        }
        return "list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Tarea());
        return "todo";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam long id) {
        Optional<Tarea> tarea = tareaService.getTodoById(id);
        if(tarea.isPresent()) {
        	Tarea tareaAux = tarea.get();
        	tareaAux.setEstado(EstadoTarea.Completada);
        	tareaService.updateTodo(tarea.get());
        }
        return "redirect:/list-todos";
    }
    
    @RequestMapping(value = "/archivar-todo", method = RequestMethod.GET)
    public String archivarTodo(@RequestParam long id) {
        Optional<Tarea> tarea = tareaService.getTodoById(id);
        if(tarea.isPresent()) {
        	Tarea tareaAux = tarea.get();
        	tareaAux.setEstado(EstadoTarea.Archivada);
        	tareaService.updateTodo(tarea.get());
        }
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Tarea tarea = tareaService.getTodoById(id).get();
        model.put("todo", tarea);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Validated Tarea tarea, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        tareaService.updateTodo(tarea);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Validated Tarea tarea, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        
        System.out.println(tarea.getNombre());
        //la guarda bien
        
        tareaService.addTodo(tarea.getNombre(),tarea.getDescripcion(),tarea.getPrioridad(),tarea.getIntduracion(), tarea.getTipoduracion());
        return "redirect:/list-todos";
    }
}
