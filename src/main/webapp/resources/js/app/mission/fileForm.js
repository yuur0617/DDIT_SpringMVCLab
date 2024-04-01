/**
 * 
 */
const cPath = document.body.dataset.contextPath;

document.addEventListener("DOMContentLoaded", ()=>{
	const refreshFileArea = jsonObj=>{
		let ulTag = document.createElement("ul");
		ulTag.innerHTML = jsonObj.map(n=>`
								<li><a href="${cPath}/mission/file/${n}">${n}</a></li>
							`).join("\n");
		document.querySelector("#fileArea").replaceChildren(ulTag);
	};
	
	fetch(location.href, {
		headers:{
			"accept":"application/json"
		}
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("요청 처리 과정에서 문제 발생", {cause:resp});
		}
	}).then(refreshFileArea)
	.catch(err=>console.error(err));
	
	fileForm.addEventListener("submit", (event)=>{
		event.preventDefault();
		let form = event.target;
		let formData = new FormData(form);
		fetch(form.action, {
			method:form.method,
			headers:{
				"accept":"application/json"
			},
			body:formData
		}).then(resp=>{
			if(resp.ok){
				return resp.json();
			}else{
				throw new Error("요청 처리 과정에서 문제 발생", {cause:resp});
			}
		}).then(refreshFileArea)
		.catch(err=>console.error(err));
	});
});


















