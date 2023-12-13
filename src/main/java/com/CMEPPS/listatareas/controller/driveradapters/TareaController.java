package com.CMEPPS.listatareas.controller.driveradapters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CMEPPS.listatareas.model.application.EstadoTarea;
import com.CMEPPS.listatareas.model.application.Tarea;
import com.CMEPPS.listatareas.model.application.Usuario;
import com.CMEPPS.listatareas.service.driverport.ITareaService;
import com.CMEPPS.listatareas.service.driverport.IUsuariosServicio;

@Controller
public class TareaController {
	
	private int tipo = 1;
	private Usuario usuario = null;
	
    @Autowired
    private ITareaService tareaService;
    @Autowired
    private IUsuariosServicio usuarioService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(@RequestParam("username")String user,ModelMap model) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        if(usuario.isAdmin()) {
        	model.put("todos", tareaService.getTodos());
        }
        else {
        	model.put("todos", tareaService.getTodosByUser(usuario.getNombre()));
        }
        return "list-todos";
    }
    
    @RequestMapping(value = "/terminadas-todos", method = RequestMethod.GET)
    public String showTTodos(@RequestParam("username")String user, ModelMap model) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
    	if(usuario.isAdmin()) {
            model.put("todos", tareaService.getTodos());
        }
        else {
        	model.put("todos", tareaService.getTodosByUser(usuario.getNombre()));
        }
        return "listT-todos";
    }
    
    @RequestMapping(value = "/filtrar-todo", method = RequestMethod.GET)
    public String searchFiltrar(@RequestParam("username")String user, ModelMap model) {
    	model.addAttribute("todo", new Tarea());
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        return "filtro-todos";
    }
    
    @RequestMapping(value = "/filtrar-todo", method = RequestMethod.POST)
    public String showFiltrar(@RequestParam("username")String user, ModelMap model, @Validated Tarea tarea, BindingResult result) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
    	if (result.hasErrors()) {
            return "filtro-todos";
        }
    	if(usuario.isAdmin()) {
            model.put("todos", tareaService.getTodosFiltro(tarea.getPrioridad()));
        }
        else {
        	model.put("todos", tareaService.getTodosFiltro(tarea.getPrioridad(),usuario.getNombre()));
        } 

        return "list-todos";
    }
    
    @RequestMapping(value = "/ordenar-todo", method = RequestMethod.GET)
    public String showOrdenar(@RequestParam("username")String user, ModelMap model) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        if(usuario.isAdmin()) {
            model.put("todos", tareaService.getTodosOrdenar(tipo));
        }
        else {
            model.put("todos", tareaService.getTodosOrdenar(tipo,usuario.getNombre()));
        }
        if(tipo != 1 && !usuario.isAdmin()) {
        	tipo = 1;
        }else if(tipo != 2 && usuario.isAdmin()){
        	tipo = 1;
        }else {
        	tipo++;
        }
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(@RequestParam("username")String user, ModelMap model) {
        model.addAttribute("todo", new Tarea());
        
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        return "todo";
    }

    @RequestMapping(value = "/terminar-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam("username")String user, @RequestParam long id, ModelMap model) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        Optional<Tarea> tarea = tareaService.getTodoById(id);
        if(tarea.isPresent()) {
        	Tarea tareaAux = tarea.get();
        	tareaAux.setEstado(EstadoTarea.Completada);
        	tareaService.updateTodo(tarea.get());
        }
        return "redirect:/list-todos?username="+user;
    }
    
    @RequestMapping(value = "/archivar-todo", method = RequestMethod.GET)
    public String archivarTodo(@RequestParam("username")String user, @RequestParam long id, ModelMap model) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
        Optional<Tarea> tarea = tareaService.getTodoById(id);
        if(tarea.isPresent()) {
        	Tarea tareaAux = tarea.get();
        	tareaAux.setEstado(EstadoTarea.Archivada);
        	tareaService.updateTodo(tarea.get());
        }
        
        return "redirect:/list-todos?username="+user;
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam("username")String user, @RequestParam long id, ModelMap model) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        Tarea tarea = tareaService.getTodoById(id).get();
        model.put("todo", tarea);
        if(tarea.getEstado()!=EstadoTarea.En_Curso) {
        	return "/list-todos";
        }
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(@RequestParam("username")String user, ModelMap model, @Validated Tarea tarea, BindingResult result) {

    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        if (result.hasErrors()) {
            return "todo";
        }
        
        tareaService.updateTodo(tarea);
        return "redirect:/list-todos?username="+user;
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(@RequestParam("username")String user, ModelMap model, @Validated Tarea tarea, BindingResult result) {
    	
    	usuario = usuarioService.getUsuarioByName(user).get();

    	model.put("user", usuario);
    	
        if (result.hasErrors()) {
            return "todo";
        }
        
        tareaService.addTodo(tarea.getNombre(),tarea.getDescripcion(),tarea.getPrioridad(),tarea.getIntduracion(), tarea.getTipoduracion(),usuario.getNombre());
        return "redirect:/list-todos?username="+user;
    }
}
