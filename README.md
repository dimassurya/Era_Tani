# Era_Tani Cloud

<h2>Infrastructure in GCP</h2>

Era Tani use infrastructure :
1. Cloud Iam & Admin
2. Cloud SQL
3. Cloud Storage
4. Compute Engine for Notebook
5. AI Platform
6. Model ML convert to Protobuf with Tensorflow
7. Billing
  
  
<h3>1. Cloud Iam & Admin</h3>
  <img width="1440" alt="Screen Shot 2021-06-09 at 15 13 56" src="https://user-images.githubusercontent.com/43495638/121318307-52879900-c935-11eb-82d3-b9348e818bdc.png">
<p>we have 2 user with the Role is Owner from the GCP Administrator and 4 users with Editor Role to use GCP</p>


<h3>2. Cloud SQL</h3>
<img width="1440" alt="Screen Shot 2021-06-09 at 15 19 28" src="https://user-images.githubusercontent.com/43495638/121319200-2b7d9700-c936-11eb-9fd4-471aca3f9c77.png">

Our Cloud SQL have 1 instance with the configuration such as :
* Region asia-southeast2 (Jakarta)
* DB Version MySQL 5.7
* vCPUs 2 vCPU
* Memory 7.5 GB
* Storage 100 GB
* Network throughput (MB/s) 500 of 2,000
* Disk throughput (MB/s) Read: 48.0 of 240.0, Write: 48.0 of 144.0
* IOPS Read: 3,000 of 15,000, Write: 3,000 of 9,000
* Connections Public IP
* Backup Automated
* Availability Multiple zones (Highly available)
* Point-in-time recovery Enabled

<img width="1440" alt="Screen Shot 2021-06-09 at 15 20 38" src="https://user-images.githubusercontent.com/43495638/121320212-253bea80-c937-11eb-8517-582ad3683a9b.png">

we have 6 users of Cloud SQL

<img width="1440" alt="Screen Shot 2021-06-09 at 15 22 26" src="https://user-images.githubusercontent.com/43495638/121320395-53212f00-c937-11eb-9841-82d67c3ef470.png">

and use 1 database is Era_Tani

<img width="1440" alt="Screen Shot 2021-06-09 at 15 40 12" src="https://user-images.githubusercontent.com/43495638/121322223-ff174a00-c938-11eb-8e43-0827828c1fbe.png">

connect and use Cloud SQL with Public Ip Address to MYSQLWorkBench



<h3>3. Cloud Storage</h3>

<img width="1440" alt="Screen Shot 2021-06-09 at 15 49 51" src="https://user-images.githubusercontent.com/43495638/121323874-65509c80-c93a-11eb-97db-c205031273ee.png">


Our Cloud storage with configuration such as :
* Location type : Region
* Location : asia-southeast2 (Jakarta)
* Default storage class : Standard
* Public access : Subject to object ACLs
* Access control : Fine-grained
* Encryption : Google-managed key



<h3>4. Compute Engine for Notebook</h3>

<img width="1440" alt="Screen Shot 2021-06-09 at 15 52 52" src="https://user-images.githubusercontent.com/43495638/121324320-d001d800-c93a-11eb-9cf5-a5ed5eae0303.png">

Compute Engine Configuration : 
* Machine type : n1-standard-2 (2 vCPUs, 7.5 GB memory)
* Reservation : Automatically choose (default)
* CPU platform : Intel Broadwell
* Zone : asia-southeast1-a

Boot Disk Configuration : 
* Name : tensorflow-2-3-20210608-101624
* Image : tf-2-3-cu110-notebooks-v20210527-debian-10
* Size(GB) : 100
* Device name : persistent-disk-0
* Type : Standard persistent disk
* Encryption : Google managed 
* Mode : Boot, read/write

Custom Metadata : 
* framework	: TensorFlow:2.3
* proxy-mode : service_account
* proxy-url	: 6c88ac1325fe6f56-dot-asia-southeast1.notebooks.googleusercontent.com
* shutdown-script	: /opt/deeplearning/bin/shutdown_script.sh
* title	: TensorFlow2.3/Keras.CUDA11.0.GPU
* version	: 71


<h3>5. AI Platform</h3>

<img width="1440" alt="Screen Shot 2021-06-09 at 15 59 28" src="https://user-images.githubusercontent.com/43495638/121325295-adbc8a00-c93b-11eb-9a7c-c7175d7536b9.png">

in AI Platform Notebook we have one instance to open Jupyter Notebook from create protobuf model machine learning to deploy in GCP


<h3>6. Model ML convert to Protobuf with Tensorflow</h3>

To safe Tensorflow Model with protobuf format we must add this code in ML model code and save it to our Cloud Storage
```Python
##saving model to bucket
BUCKET = 'first-cloud-step-308017.appspot.com'
path="gs://%s/keras-job-dir/keras_export" % BUCKET

model_e1d1.save(path) #save your model 
```

and to reload model again we must add this code in ML model code

```Python
# to reload model 
model = tf.keras.models.load_model(path)
```

after run code, new folder with protobuf model added in our Cloud Storage Bucket like this :
<img width="1440" alt="Screen Shot 2021-06-09 at 16 07 39" src="https://user-images.githubusercontent.com/43495638/121326517-d7c27c00-c93c-11eb-95b8-e9430b044985.png">



<h3>7. Billing</h3>

<img width="1440" alt="Screen Shot 2021-06-09 at 16 10 30" src="https://user-images.githubusercontent.com/43495638/121327522-b8781e80-c93d-11eb-910f-7ac6db0ecf37.png">

We have 1 billing account who use to our project

<img width="1440" alt="Screen Shot 2021-06-09 at 16 13 12" src="https://user-images.githubusercontent.com/43495638/121327629-cded4880-c93d-11eb-8ba6-5d53fd391578.png">

Set Allert for Budgeting in Rp. 3.000.000



<h2>Thank You</h2>

  
