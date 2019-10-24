package com.pedidosapp.controllers;

import javax.validation.Valid;

import com.pedidosapp.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pedidosapp.models.Carga;
import com.pedidosapp.repository.CargaRepository;
import com.pedidosapp.repository.PedidoRepository;

@Controller
public class PedidoController {

	@Autowired
	private PedidoRepository pr;
	
	@Autowired
	private CargaRepository cr;
	
	@RequestMapping(value="/cadastrarPedido", method=RequestMethod.GET)
	public String form(){
		return "pedido/formPedido";
	}


	
	@RequestMapping(value="/cadastrarPedido", method=RequestMethod.POST)
	public String form(@Valid Pedido pedido, BindingResult result, RedirectAttributes attributes){
		System.out.println("tese");
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarPedido";
		}
		
		pr.save(pedido);
		attributes.addFlashAttribute("mensagem", "Pedido cadastrado com sucesso!");
		return "redirect:/cadastrarPedido";
	}
	
	@RequestMapping("/pedidos")
	public ModelAndView listaPedidos(){
		ModelAndView mv = new ModelAndView("listaPedidos");
		Iterable<Pedido> pedidos = pr.findAll();
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesPedido(@PathVariable("codigo") long codigo){
		Pedido pedido = pr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("pedido/detalhesPedido");
		mv.addObject("pedido", pedido);
		
		Iterable<Carga> cargas = cr.findByPedido(pedido);
		mv.addObject("cargas", cargas);
		
		return mv;
	}
	
	@RequestMapping("/deletarPedido")
	public String deletarPedido(long codigo){
		Pedido pedido = pr.findByCodigo(codigo);
		pr.delete(pedido);
		return "redirect:/pedidos";
	}
	
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesPedidoPost(@PathVariable("codigo") long codigo, @Valid Carga carga, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Pedido pedido = pr.findByCodigo(codigo);
		carga.setPedido(pedido);
		cr.save(carga);
		attributes.addFlashAttribute("mensagem", "Carga adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	@RequestMapping("/deletarCarga")
	public String deletarCarga(String id){
		Carga carga = cr.findById(id);
		cr.delete(carga);
		
		Pedido pedido = carga.getPedido();
		long codigoLong = pedido.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}
}	
