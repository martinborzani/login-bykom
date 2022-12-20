const app = Vue.createApp({
    data(){
        return{
            data: [],
            url: "http://localhost:8080/api/clients",
            email:"",
            password:"",
            name:"",
        }
    },
    created(){
        this.loadData(this.url);
    },
    methods:{

        loadData(url){
            axios.get(url)
            .then((response) =>{
                this.data = response.data;
                console.log(this.data);
                this.name = this.data.name;
            })
        },
        login(){
            axios.post('/api/login',`email=${this.email}&password=${this.password}`)
            .then(() =>{

                window.location.assign("account.html");

            })
        }        

    }
}).mount('#app');