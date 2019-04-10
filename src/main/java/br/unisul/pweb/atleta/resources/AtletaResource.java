package br.unisul.pweb.atleta.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.unisul.pweb.atleta.domain.Atleta;
import br.unisul.pweb.atleta.services.AtletaService;

@RestController
@RequestMapping(value="/atletas")
public class AtletaResource {
	
	@Autowired
	private AtletaService service;
	
	//BUSCAR POR ID
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<Atleta> find(@PathVariable Integer id){
			Atleta obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}
		
		//LISTAR TODAS
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<Atleta>> findAll() {
			List<Atleta> lista = service.findAll();
			return ResponseEntity.ok().body(lista);
		}

}
