-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: ailab
-- ------------------------------------------------------
-- Server version	5.5.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ailab`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ailab` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ailab`;

--
-- Table structure for table `body_parts`
--

DROP TABLE IF EXISTS `body_parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `body_parts` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body_parts`
--

LOCK TABLES `body_parts` WRITE;
/*!40000 ALTER TABLE `body_parts` DISABLE KEYS */;
INSERT INTO `body_parts` VALUES ('chest',1),('abdominal',2),('pulmonary',3),('brain',4),('pancreatic',5),('heart',6),('stomach',7),('abdomen',8),('cranial',9),('head',10),('kidney',11),('bladder',12);
/*!40000 ALTER TABLE `body_parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `common`
--

DROP TABLE IF EXISTS `common`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `common` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `common`
--

LOCK TABLES `common` WRITE;
/*!40000 ALTER TABLE `common` DISABLE KEYS */;
INSERT INTO `common` VALUES ('he',1),(' his ',2),(' him ',3),(' her ',4),(' she ',5),(' hers ',6),(' i ',7),(' me ',8),('my',9),(' dr. ',10),(' dr ',11),(' md ',12),(' m.d. ',13),(' prior ',14),(' the ',15),(' patient ',16),(' a ',17),(' , ',18),(' is ',19),('i',51),('the',26),(' \'s ',22),(' therapy ',23),('your',35),('an',25),('at',52),('this',28),('treatment',29),('surgery',30),('procedure',31),('m.d',33),('you',36),('yours',37),('primary',38),('care',39),('doctor',40),('service',41),('team',42),('we',43),('they',44),('and',48),('-',46),('&apos;s',47),('name',56),('to',55),('several',71),('any',58),('or',59),('multiple',60),('tissue',61),('full',66),('part',64),('1',65),('complications',68),('complication',69),('small',70),('severe',72),('ischemic',73),('ischemia',74),('infection',75),('afebrile',76),('over',77),('low',78),('depressed',79),('massive',80),('condition',82),('widespread',83),('mild',84),('&quot;',85),('his',86),('me',88),(':',89),('examination',90);
/*!40000 ALTER TABLE `common` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=1409 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('dr.',1),('m.d.',2),('md',3),('dr ',4),('doctor ',5),(' doctor',6),('attending',7),('pcp',8),('m.d',9),('psychiatrist',10),('cardiologist',11),('primary care physician',12),('oncologist',13),('hepatologist',14),('primary care doctor',15),('orthopedic surgeon',16),('cardiology',17),('physical therapy',18),('provider',19),('toxicology',21),('cmed',22),('pulmonary',23),('service',24),('team',25),('infectious disease',26),('anesthesia',27),('security',28),('mahoney',29),('id',30),('mother',31),('father',32),('surgery',33),('plastic surgery',34),('brother',36),('dr',37),('surgeon',38),('urologist',39),('nephrologist',418),('preliminary',417),('pathology',413),('urinary',58),('electrophysiology',395),('primary',77),('gastroenterologist',78),('rheumatologist',386),('radiologist',88),('urology',107),('neurology',108),('oncology',111),('hematologist',113),('emts',600),('partner',582),('association',581),('nurse',580),('spine',576),('guardian',575),('sister',551),('friend',573),('omfs',574),('secretary',180),('dentistry',195),('psychiatry',203),('gastroenterology',238),('niece',571),('caregiver',572),('ophthalmology',269),('ettrent can',619),('loved ones',614),('nephrology',334),('doctor',613),('medical',612),('vascular',611),('surgeons',610),('vascular surgeons',609),('neurosurgeon',608),('neurosurgeons',607),('ent physicians',616),('private',605),('physicians',615),('medical doctor',603),('private medical doctor',602),('coronary',353),('emt',601),('hematology',355),('son',595),('son-in-law',594),('nieces',593),('grandchildren',599),('p.t.',591),('gi consult',598),('dermatology',363),('infectious',589),('disease',588),('consult',597),('pharmacy',586),('nephew',585),('therapy',584),('neurosurgery',570),('spouse',568),('pulmonologist',419),('neurosurg',569),('husband',567),('nurses',579),('o.t.',565),('occupational therapy',564),('visitor',578),('ems',562),('ettrent',621),('doctors',622),('neuro-oncologist',556),('neurologist',555),('children',596),('physician',553),('wife',550),(' np',547),('visiting nurses association',577),('family',543),('and',540),('swallow',539),('speech',538),('speech and swallow',537),('daughter',535),('wound care',533),('symptomatology',531),('ophthalmologist',530),('care',532),('pathologist',528),('cytologist',527),('biliary',526),('rheumatology',463),('podiatrist',525),('oximetry',524),('technologist',523),('podiatry',522),('radiology',623),('relatives',624),('ear/nose/throat',625),('throat',626),('nose',627),('ear',628),('twin',629),('kids',630),('medicine',631),('transplant',632),('renal',633),('renal transplant medicine',634),('renal transplant',635),('transplant surgery',636),('mom',637),('emergency department',638),('emergency',639),('department',640),('visiting',641),('nursing',642),('visiting nursing',643),('dictator',644),('ip',645),('the specialist',646),('specialist',647),('some friends',648),('friends',649),('internist',654),('myself',653),('loved',652),('her internist',655),('their',656),(' md',657),('1st',658),('long-term anticoagulation',708),('beta-blockers',661),('urine output',683),('synthroid',719),('icu',681),('endoscopic retrograde cholangiopancreatography',720),('trials',671),('chest',672),('previous diabetes medications',675),('obesity',684),('social worker',692),('evaluation',718),('pediatrician',688),('jacqueline',725),('preschool siblings',694),('her sibling',695),('staff',712),('a tagged rbc scan',716),('gi',699),('dvts',710),('recurrent',709),('previous hct',702),('the infant',724),('acute bleed',704),('colonoscopy',705),('home insulin regimen',706),('recurrent dvts',707),('a gavage tube',726),('rigidity',721),('anion gap acidosis',722),('home o2 dose',727),('this patient',728),('current cardiac failure',729),('respiratory sx',730),('prescriptions',731),('sarcoidosis',732),('prograf level',733),('prior echocardiogram',734),('most recent prograf level',735),('rathelife , tieanaki b',1210),('neurologists',737),('heme',738),('home health aide',739),('health aide',740),('aide',741),('an incidental pass',742),('extubate',743),('additional therapy.',744),('baby girl fritsche',745),('infants',746),('school age siblings',747),('household contacts',748),('tai pamela wendell',749),('resident',750),('meter-dosed inhaler',751),('anicteric',752),('meter-dosed inhalers',753),('prednisone compliance',754),('steroid-induced diabetes',755),('sputum culture',756),('her fasting blood sugars',757),('fasting blood sugars',758),('peak flows',759),('her blood pressure',760),('robert murrell',761),('the ccu fellow',762),('cards fellow',763),('her peak flows',869),('her ptx',765),('arf',766),('ongoing pericardial effusion',767),('effusions',768),('pulsus parodoxicus',769),('lewin',770),('pericardial drainage',771),('odell',772),('fellow',773),('air hunger',774),('05-28 cxr',775),('large pericardial effusion',776),('preload',777),('dilt',778),('additional a fib control',779),('anginal equivalent',781),('cardiac medications',782),('asthma attacks',783),('benadryl',784),('right heart cath',870),('betamethasone',787),('a shortened cervix',788),('other caregivers',790),('cold',791),('paxil',792),('elevated fs',793),('extubation',794),('theresa leonore np',795),('vasoactive drips',796),('loose teeth',797),('non-dysmorphic premature infant',799),('weight',800),('head circumference',801),('the parents',802),('glucagon drips',803),('cks',804),('other medications',806),('labs',807),('a fib',871),('orthopedics',809),('head injury',810),('mouth-to-mouth resuscitation',811),('endurance training',812),('overall fluid status',813),('hospitalization',814),('a patient',815),('dad',816),('some discoordination of his suck',817),('am hct',818),('mdi',819),('baseline 02 requirement',820),('ace inhibitor',821),('severe copd',822),('am bp meds',823),('hcts',824),('bp meds',825),('low bp',826),('further bp titration',827),('mild diarrhea',828),('stents',829),('guiac positive stools',830),('guiac pos stools',831),('the catheterization',832),('weak right leg',833),('severe dysarthria',834),('tpa',835),('bipolar disorder',836),('home dose of zocor',837),('further ischemia',838),('gait difficulties',839),('previous strokes',840),('knee injury',841),('orthopaedics',842),('knee meniscal tear',843),('cardiac history',844),('chf',845),('monitoring of her electrolytes',872),('prior mi',847),('blood pressure meds',850),('coumadin level',851),('main issue',852),('cesarean section',853),('maintenance dose',854),('ann kenneth np',855),('flaccid right arm',873),('left foot ulcer',857),('ventilator',858),('diabetes mellitus',859),('foot infection',860),('leg ulcer',861),('burltis trowelks',1211),('preoperative medications',863),('intracranial pressure',864),('serum osmolalities',865),('systemic blood pressures',866),('cerebral perfusion pressure',867),('clinical examination',868),('a stress test',874),('carafate',875),('gram-negative rods',876),('body temperature',877),('central venous pressure',878),('the surgical',879),('resuscitation',880),('tracheostomy',881),('wounds',882),('pressors',883),('pressure',884),('nephrostomy tube',885),('rate control',886),('oxygenation',887),('significant infection',888),('chronic hypothyroidism',889),('increasing shortness of breath',890),('marie',891),('bp medications',892),('x. neuse',893),('ifex infusion',894),('vp-16',895),('bilirubin',896),('newborn screens',897),('terrance',898),('jennifer martin',899),('trach collar',900),('nutrition regimen',901),('doboff tube',902),('poor nutritional status',903),('mental status change',904),('recent mrsa pneumonia',905),('j-tube',906),('medication regimen',907),('driver',1405),('vna',909),('significant other',1407),('tcu',1406),('echocardiogram study results',912),('incisions',913),('immunosuppression',914),('levophed drip',915),('h e',916),('seizures',917),('lumbar drain',918),('head incision',919),('head wound',920),('wound site',921),('neursurg',922),('a superficial ulcerations on her foot',923),('dnr',924),('supervisor',1404),('clinic',1403),('initial oxygen sat',927),('r heel wound',928),('dose',929),('ng tube feeds',930),('toprol',931),('digoxin',932),('cardiomyopathy',933),('elevated cardiac enzymes',934),('elevated wedge pressures',935),('right lower lobe infiltrate',936),('right heart catheterization',937),('biopsy',938),('icd placement',939),('dnr/dni',940),('comfort measures',941),('presumed aspiration',942),('thoracotomy',943),('initial neurologic examination',944),('balloon pump',945),('blood transfusions',946),('only yeast source',947),('split thickness skin grafts',948),('trach',949),('pacing lead',950),('external pacemaker ddd',951),('midabdominal incision',952),('jejunostomy tube',953),('dialysis',954),('albumin',955),('cd4 count',956),('vaccines',957),('iv steroids',958),('haart regimen',959),('new beta blocker',960),('low urine output',961),('hickman catheter',962),('flolan',963),('valium',964),('facial twitching',965),('last mri',966),('altered mental status',967),('pt/ot',968),('kitty pamela np',969),('epidural',970),('gestational carrier',971),('twins',972),('dr. ronald',973),('dr. lueras',974),('dr. charles y.s. warnock',975),('angie cm johnson , m.d.',977),('ryrol daledae , np',1222),('2 daughters',1221),('ri strength',1220),('dr. alvarado',981),('dr. mullins',982),('name',1219),('your primary care physician / urologist',984),('bernice jessica md',985),('carol lydia md',986),('dr. elizabeth gs vega',987),('ross z kenmore , m.d.',988),('dr. rowles',990),('ftloyd , lette d',1218),('his oncologist',993),('dr. scott ann , md',994),('dr erb',995),('akote , ralpri',1217),('your oncologist',997),('brooke donna md',998),('jessica pope md',999),('breunlinke',1216),('his pmd',1215),('her hepatologist',1002),('dr. steidl',1003),('her pcp',1004),('dr. popoff',1005),('the icu team',1006),('the family',1007),('the medical team',1008),('tracy doris md',1009),('melvin thomas md',1010),('dr. micheal j. rozzi',1011),('the doctor',1012),('round',1214),('primary pediatrician',1014),('beverly q. bailey , m.d.',1015),('carmen y.r. martinez , m.d.',1016),('kristie r. hamby , m.d.',1017),('antonio m. z. eddings , m.d.',1018),('his pcp',1019),('lucio f. r. matthews , m.d.',1020),('drs. freierm',1213),('your gastroenterologist',1022),('alan john md',1023),('bertha janice motta md',1024),('dr. melody parks',1025),('sarah q. george , m.d.',1026),('a daughter',1028),('two children',1029),('dr. jason long',1030),('trowelks , burltis',1212),('the staff radiologist',1032),('dr. billy l. boender',1033),('dr. pat k. walton',1034),('frank linda md',1035),('dr. marta keever',1036),('dr. alonso naugle',1037),('dr. james deighan',1038),('jason l parra , m.d.',1039),('dr. wanda parks',1040),('dr. nicholson',1041),('her primary care physician',1042),('marcelene r. brennan , m.d.',1043),('dr. ruth o. black',1044),('dr. joseph',1045),('robert mincer , m.d.',1046),('penny k. mcbride , m.d.',1047),('dr. kenneth rhein',1048),('timothy e woolfolk , m.d.',1049),('robert c. warren , m.d.',1050),('dr. kevin arthur',1051),('dr. amanda hilton',1052),('kevin f juliusson , m.d.',1053),('by:anita x. duffy , m.d.',1054),('dr. vanessa riker',1055),('dr. ______________',1056),('kathy tillis , m.d.',1057),('john v.e. jameson , m.d.',1058),('dr. kathy tillis',1059),('his surgeon',1060),('our ip team',1061),('john iris md',1062),('patricia rojas md',1063),('dr. john j. booker',1064),('dr. debra oneal',1065),('his cardiologist',1067),('saul n. keehne , m.d.',1068),('shirley y waler , m.d.',1069),('dr. william spencer',1070),('the renal and surgical residents',1071),('sister in law',1209),('dr. jones',1074),('dr. yost',1075),('dr. miller',1076),('dr. thomas rosier',1077),('dr. marie anderson',1078),('dr. ross',1079),('terry cr dennis , m.d.',1080),('tracy c rea , m.d.',1081),('dr. antonio hall',1082),('gayle m whitener , m.d.',1083),('sister-in-law',1208),('cardiololgy',1207),('the neurology consult service',1089),('the physical therapist',1206),('juanita',1205),('the oncology consult service',1092),('mark yvonne np',1204),('her outside hematologist dr. pauling',1094),('dr . pauling',1095),('jacque john md',1096),('dr. richard ronald lockett',1097),('twin b',1098),('dr. kim adams',1099),('out of home care givers',1100),('kurt s imperato , m.d.',1101),('dr. debbie tran',1102),('several foster children',1103),('rau',1203),('the medical intensive care unit attending',1105),('scott robert np',1202),('dr. jeanette barr',1107),('james z berg , m.d.',1108),('dr. andrea trotter',1109),('derrick l. mayo , m.d.',1110),('the procedure team',1111),('renal consultants',1112),('johannes',1201),('cardiology attending',1114),('the ccu staff',1115),('jessica ashley md',1116),('dr. barry smith',1117),('dr. benson',1118),('dr. luedeman,melissa',1119),('andrew c hoffman , m.d.',1120),('dr. andrew x.. dale',1121),('daniel z. h. walton , m.d.',1122),('a new pcp',1123),('your cardiology',1125),('dr. villani',1126),('a primary care physician',1127),('dr. lesha lefebvre',1128),('ralph katherine md',1129),('terry smith md',1130),('dr. jennifer applebee',1131),('ernest k. gardner , m.d.',1132),('sarah z stephens , m.d.',1133),('dr. billie schneider',1134),('dr. penny scott',1135),('dr. parramore',1136),('janna l. desorbo , m.d.',1137),('dr. bernice jenkins',1138),('george xl patrick , m.d.',1139),('his primary physician',1140),('your doctor',1141),('your primary doctor',1142),('clemmie shawn md',1143),('michael melvin kinzer md',1144),('dr. justin pappas',1145),('luis jg lavoie , m.d.',1146),('may chen , pa.',1200),('liver teams',1199),('carol robert np',1198),('dr. dewhurst',1151),('dr. burns',1152),('chad barbara md',1153),('dr. eugene offutt',1154),('1st degree relatives',1155),('primary cardiologist',1157),('steven welch',1197),('doctors marilyn kristen layne',1159),('james',1196),('your cardiologist',1161),('robert melissa md',1163),('william bennett md',1164),('dr. evelyn paulk',1165),('dr. hortencia conner',1166),('other care givers',1167),('dr. avon',1168),('brian lt wentzel , m.d.',1169),('dr. john bonilla',1170),('michael n sawyer , m.d.',1171),('rebecca s jefcoat , m.d.',1172),('dr. dorothy desalvo',1173),('geoffrey f corney , m.d.',1174),('your pcp',1176),('dr. jessie',1177),('dr. hemler',1178),('dr. colombo',1179),('dr. powell',1180),('james jennifer md , phd',1181),('kimberly sarah md',1182),('dr. joanne gilbert yang',1183),('the orthopedics service',1184),('neurosurgical service',1185),('the neuro-rehabilitation service',1188),('the gestational carrier',1194),('dr. johnson',1191),('maria l. bell , m.d.',1192),('michael x. fisher , m.d.',1193),('the dietician',1223),('liley , peantsall',1224),('crutch , naeelv',1225),('the examiner',1226),('examiner',1227),('kotejoasthoreuphkays',1228),('newborn',1229),('gastrointestinal',1230),('wwww',1231),('drs. eeeee',1232),('the gastroenterologists',1233),('well-developed, well-nourished individual',1234),('them',1236),('a homemaker',1237),('ent',1238),('attend',1239),('**name[yyy m] jr',1240),('**name[yyy zzz] jr',1241),('r.n.',1242),('the intensivist',1243),('physical therapist',1244),('occupational therapist',1245),('the medics',1246),('residents',1247),('home health',1248),('cardiovascular',1249),('author',1250),('consultants',1251),('metlife',1252),('dentist',1253),('behavioral health',1254),('microbiology',1255),('psych',1263),('consults',1257),('the neurologic consultant',1258),('the orthopedic office',1259),('the er',1260),('a chiropractor',1261),('cardiac rehab',1262),('crnp',1264),('m.d.-thomas d. ***',1265),('028200-painter , m.d.-thomas d.',1266),('her poa',1267),('ophthlologist',1268),('a healthy volunteer',1276),('ortho',1270),('plastic',1272),('social services',1274),('the nicu',1275),('pancreaticobiliary',1277),('the sleep  lab',1278),('neuro',1279),('dr.parson',1280),('strickland',1281),('mark eugene np',1282),('trauma',1283),('christopher sandy np',1284),('cardiothoracic',1285),('jerry pamela np',1286),('sisters',1287),('brothers',1288),('sitter',1290),('omalley',1291),('social work',1292),('jeremy n. p. moschella pa',1293),('sheena',1294),('endocrine',1295),('gardner state hospital social worker',1296),('the contact',1297),('sick contact',1298),('multiple siblings',1299),('pocasset',1300),('neonatology',1301),('his orthopedist',1355),('david bull',1303),('trasplant',1304),('mr stutts',1305),('her daughters',1306),('endocrinologist',1307),('her endocrinologist',1308),('hcp',1309),('glenn shives',1310),('michael edwards',1311),('evelyn matos',1312),('home pt',1313),('a arbour hospital social worker',1314),('contact social worker',1315),('cccountry',1401),('dr.hastings',1317),('hale air force base pediatrics',1318),('preschool age siblings',1319),('otolaryngology',1320),('the paramedics',1354),('a asian interpreter',1325),('andrea',1326),('ms crossman',1327),('kimberly',1328),('cousins',1329),('cousin',1330),('caregivers',1331),('a , rebay j',1353),('sibling',1333),('siblings',1334),('gach , ch',1352),('teams',1336),('services',1338),('ginslent , a l',1351),('daughters',1340),('companions',1341),('companion',1342),('grandsons',1343),('grandson',1344),('roommate',1408),('parents',1346),('attendings',1350),('her child',1349),('cardiac surgical',1356),('sons',1402),('his health-care proxy',1358),('neuro-ophthalmology',1359),('your obstetrician',1361),('obstetrician',1362),('allergy',1363),('the smoking cessation program',1364),('the swallowing therapist',1365),('/pcp',1366),('multiple sexual partners',1367),('gynecologist',1368),('thoracic surgical',1375),('obstetrical',1370),('gyn / onc',1371),('sterpmoone , ny',1372),('therapist',1373),('interpreter',1374),('phyisican',1376),('paramedics',1377),('consulting physicians:',1378),('a diabetic educator',1379),('oculoplastic',1380),('the clinic coordinator',1381),('rehab',1382),('homecare',1383),('pulmonology',1384),('housestaff',1388),('surgical',1386),('the va hospital administrators',1387),('discharge planning',1390),('rheum',1392),('intern',1393),('derm',1394),('geripsych',1398),('hospice',1399),('c.n.m.',1400);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_actions`
--

DROP TABLE IF EXISTS `doctor_actions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_actions` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_actions`
--

LOCK TABLES `doctor_actions` WRITE;
/*!40000 ALTER TABLE `doctor_actions` DISABLE KEYS */;
INSERT INTO `doctor_actions` VALUES ('prescribed',1),('prescribe',2),('clinic',3),('office',4),('clinic',5);
/*!40000 ALTER TABLE `doctor_actions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `future_headings`
--

DROP TABLE IF EXISTS `future_headings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `future_headings` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `future_headings`
--

LOCK TABLES `future_headings` WRITE;
/*!40000 ALTER TABLE `future_headings` DISABLE KEYS */;
INSERT INTO `future_headings` VALUES ('discharge instructions :',1),('discharge diagnosis :',2),('discharge condition :',3),('medications on discharge :',6),('additional comments :',7),('disposition on discharge :',9);
/*!40000 ALTER TABLE `future_headings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `future_tense`
--

DROP TABLE IF EXISTS `future_tense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `future_tense` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `future_tense`
--

LOCK TABLES `future_tense` WRITE;
/*!40000 ALTER TABLE `future_tense` DISABLE KEYS */;
INSERT INTO `future_tense` VALUES ('if you experience',4),('please call',10),('please notify',13);
/*!40000 ALTER TABLE `future_tense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headings`
--

DROP TABLE IF EXISTS `headings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headings` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headings`
--

LOCK TABLES `headings` WRITE;
/*!40000 ALTER TABLE `headings` DISABLE KEYS */;
INSERT INTO `headings` VALUES ('past medical history:',1),('history of present illness :',2),('major surgical procedures :',4),('follow up :',5),('discharge medications :',6),('discharge condition :',7),('hospital course :',8),('social history :',9),('medications :',10),('discharge instructions :',12),('discharge diagnosis :',14),('discharge disposition :',15),('medications on admission :',16);
/*!40000 ALTER TABLE `headings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital_course_procedures`
--

DROP TABLE IF EXISTS `hospital_course_procedures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital_course_procedures` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_course_procedures`
--

LOCK TABLES `hospital_course_procedures` WRITE;
/*!40000 ALTER TABLE `hospital_course_procedures` DISABLE KEYS */;
INSERT INTO `hospital_course_procedures` VALUES ('procedure',1),('transplant',2),('surgery',3);
/*!40000 ALTER TABLE `hospital_course_procedures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `is_phrases`
--

DROP TABLE IF EXISTS `is_phrases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `is_phrases` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `is_phrases`
--

LOCK TABLES `is_phrases` WRITE;
/*!40000 ALTER TABLE `is_phrases` DISABLE KEYS */;
INSERT INTO `is_phrases` VALUES ('most consistent with',1),('consistent with',2),('is',3),('was',4),('as',5),('as &quot;',6),('was with',7),('called',8);
/*!40000 ALTER TABLE `is_phrases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_headings`
--

DROP TABLE IF EXISTS `past_headings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `past_headings` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_headings`
--

LOCK TABLES `past_headings` WRITE;
/*!40000 ALTER TABLE `past_headings` DISABLE KEYS */;
INSERT INTO `past_headings` VALUES ('history of present illness :',1),('past medical history :',2),('history and reason for hospitalization :',11);
/*!40000 ALTER TABLE `past_headings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_tense`
--

DROP TABLE IF EXISTS `past_tense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `past_tense` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_tense`
--

LOCK TABLES `past_tense` WRITE;
/*!40000 ALTER TABLE `past_tense` DISABLE KEYS */;
INSERT INTO `past_tense` VALUES (' prior ',1),(' was ',2),('had',3);
/*!40000 ALTER TABLE `past_tense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `present_headings`
--

DROP TABLE IF EXISTS `present_headings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `present_headings` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `present_headings`
--

LOCK TABLES `present_headings` WRITE;
/*!40000 ALTER TABLE `present_headings` DISABLE KEYS */;
INSERT INTO `present_headings` VALUES ('hospital course :',1),('major surgical procedures :',2),('medications :',3),('4. hematology :',14),('conclusions :',5),('brief hospital course :',6),('laboratory data :',7),('imaging studies :',8),('procedures :',9),('1. cardiovascular :',10),('3. infectious disease :',11),('additional comments :',16),('5. fluids / electrolytes / nutrition :',13),('hematology :',15);
/*!40000 ALTER TABLE `present_headings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `present_tense`
--

DROP TABLE IF EXISTS `present_tense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `present_tense` (
  `word` varchar(50) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `present_tense`
--

LOCK TABLES `present_tense` WRITE;
/*!40000 ALTER TABLE `present_tense` DISABLE KEYS */;
INSERT INTO `present_tense` VALUES (' is ',1),(' currently ',2);
/*!40000 ALTER TABLE `present_tense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronoun`
--

DROP TABLE IF EXISTS `pronoun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pronoun` (
  `word` varchar(15) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronoun`
--

LOCK TABLES `pronoun` WRITE;
/*!40000 ALTER TABLE `pronoun` DISABLE KEYS */;
INSERT INTO `pronoun` VALUES ('he',1),('him',2),('his',4),('yourself',27),('her',6),('hers',7),('she',8),('me',10),('my',11),('you',12),('your',13),('yours',14),('which',20),('that',19),('this',18),('who',21);
/*!40000 ALTER TABLE `pronoun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `queries`
--

DROP TABLE IF EXISTS `queries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `queries` (
  `word` varchar(150) NOT NULL,
  `results` varchar(800) NOT NULL,
  `number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=6281 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `queries`
--

LOCK TABLES `queries` WRITE;
/*!40000 ALTER TABLE `queries` DISABLE KEYS */;
INSERT INTO `queries` VALUES ('drs. llllll','',6279),('mrs. cccccccc','',6280),('drs. llllll','',6278),('mrs. bbbbbbb','',6277),('the tcu','',6267),('tcu','',6268),('significant other','',6269),('homestead','',6270),('a roommate','',6271),('mrs. bbbbbbb','',6272),('mrs. bbbbbbb','',6273),('mrs. bbbbbbb','',6274),('mrs. bbbbbbb','',6275),('mrs. bbbbbbb','',6276),('sons','',6265),('the tcu','',6266),('mrs. kkk','',6262),('ccccccccccccccc','',6263),('mrs. aaaaa','',6264),('an excellent candidate','',6255),('a driver','',6256),('driver','',6257),('mrs. wwwwww','',6258),('the driver','',6259),('the supervisor','',6260),('supervisor','',6261),('robert','',4873),('richard','',4874),('s.','',4875),('humphries','',4876),('degree','',4877),('marilyn','',4878),('kristen','',4879),('melissa','',4880),('bennett','',4881),('evelyn','',4882),('paulk','',4883),('previous','',4884),('layne','',4885),('william','',4886),('mr.','',4887),('who','',4888),('angie','',4889),('cm','',4890),('johnson','',4891),('andersen','',4892),('alvarado','',4893),('mullins','',4894),('/','',4895),('mary','',4896),('francis','',4897),('z.','',4898),('laurie','',4899),('paul','',4900),('g.','',4901),('bernice','',4902),('jessica','',4903),('carol','',4904),('lydia','',4905),('elizabeth','',4906),('gs','',4907),('vega','',4908),('colon','',4909),('cancer','',4910),('void','',4911),('trials','',4912),('chest','',4913),('ross','',4914),('z','',4915),('kenmore','',4916),('rowles','',4917),('scott','',4918),('ann','',4919),('erb','',4920),('brooke','',4921),('donna','',4922),('pope','',4923),('he','',4924),('previous diabetes medications','',4925),('your','',4926),('you','',4927),('mr. andersen','',4928),('patient','',4929),('the','',4930),('his','',4931),('mary , francis z.','',4932),('laurie , paul g.','',4933),('her','',4934),('she','',4935),('him','',4936),('maryjane','',4937),('ws','',4938),('hammond','',4939),('the pt','',4940),('terry','',4941),('trott','',4942),('closest','',4943),('members','',4944),('mary francis','',4945),('laurie paul','',4946),('steidl','',4947),('popoff','',4948),('icu','',4949),('tracy','',4950),('doris','',4951),('melvin','',4952),('thomas','',4953),('micheal','',4954),('rozzi','',4955),('urine output','',4956),('obesity','',4957),('worsening liver failure','',4958),('gerardo','',4959),('37','',4960),('year','',4961),('old','',4962),('gravida','',4963),('para','',4964),('0','',4965),('#1','',4966),('baby','',4967),('social','',4968),('worker','',4969),('barbara','',4970),('cole','',4971),('vito','',4972),('dotzler','',4973),('preschool','',4974),('siblings','',4975),('vetrano','',4976),('sibling','',4977),('both','',4978),('pediatrician','',4979),('beverly','',4980),('bailey','',4981),('carmen','',4982),('y.r.','',4983),('the patient','',4984),('they','',4985),('j.','',4986),('q.','',4987),('martinez','',4988),('lizzie','',4989),('calkins','',4990),('the baby','',4991),('social worker','',4992),('barbara cole','',4993),('preschool siblings','',4994),('her sibling','',4995),('kristie','',4996),('r.','',4997),('hamby','',4998),('antonio','',4999),('m.','',5000),('eddings','',5001),('mr','',5002),('peres','',5003),('gi','',5004),('jason','',5005),('leon','',5006),('lucio','',5007),('y.','',5008),('matthews','',5009),('f.','',5010),('white','',5011),('leslie','',5012),('l.','',5013),('alan','',5014),('john','',5015),('bertha','',5016),('janice','',5017),('motta','',5018),('melody','',5019),('parks','',5020),('previous hct','',5021),('a tagged rbc scan','',5022),('acute bleed','',5023),('colonoscopy','',5024),('cad/chf','',5025),('home regimen','',5026),('home insulin regimen','',5027),('recurrent dvts','',5028),('fluid','',5029),('his bp','',5030),('a large , bloody bowel movement','',5031),('mr peres','',5032),('a pe','',5033),('long-term anticoagulation','',5034),('long-term','',5035),('recurrent','',5036),('dvts','',5037),('white , leslie l.','',5038),('95 yo f','',5039),('sarah','',5040),('george','',5041),('two','',5042),('long','',5043),('staff','',5044),('billy','',5045),('boender','',5046),('pat','',5047),('walton','',5048),('ms.','',5049),('pimental','',5050),('frank','',5051),('linda','',5052),('deanna','',5053),('patague','',5054),('marta','',5055),('keever','',5056),('elinor nicole','',5057),('previously diagnosed methicillin resistant , coagulase negative staph bacteremia','',5058),('ronald','',5059),('lueras','',5060),('elinor','',5061),('nicole','',5062),('wells','',5063),('charles','',5064),('y.s.','',5065),('warnock','',5066),('mary francis z.','',5067),('laurie paul g.','',5068),('tagged rbc scan','',5069),('white leslie l.','',5070),('ms. pimental','',5071),('s patie','',5072),('dfa','',5073),('evaluation','',5074),('synthroid','',5075),('linette randall','',5076),('endoscopic retrograde cholangiopancreatography','',5077),('rigidity','',5078),('anion gap acidosis','',5079),('baby boy liles','',5080),('infant','',5081),('s a patie','',5082),('the infant','',5083),('jacqueline','',5084),('a gavage tube','',5085),('home o2 dose','',5086),('this patient','',5087),('current cardiac failure','',5088),('himself','',5089),('home health aide','',5090),('respiratory sx','',5091),('mr . davison','',5092),('prescriptions','',5093),('sarcoidosis','',5094),('prograf level','',5095),('prior echocardiogram','',5096),('most recent prograf level','',5097),('30-year-old woman','',5098),('neurologists','',5099),('heme','',5100),('30 yo f','',5101),('an incidental pass','',5102),('extubate','',5103),('additional therapy.','',5104),('further available treatment','',5105),('baby girl fritsche','',5106),('a 34 - year-old g2 p1 now 2 woman','',5107),('mills','',5108),('infants','',5109),('a smoker','',5110),('school age siblings','',5111),('household contacts','',5112),('tai pamela wendell','',5113),('resident','',5114),('meter-dosed inhaler','',5115),('anicteric','',5116),('meter-dosed inhalers','',5117),('prednisone compliance','',5118),('steroid-induced diabetes','',5119),('sputum culture','',5120),('her fasting blood sugars','',5121),('fasting blood sugars','',5122),('peak flows','',5123),('her blood pressure','',5124),('robert murrell','',5125),('the ccu fellow','',5126),('cards fellow','',5127),('murphy , robert leigh','',5128),('murphy , robert sanchez','',5129),('her pacer','',5130),('a ptx','',5131),('ct placement','',5132),('her ptx','',5133),('pacer','',5134),('ptx','',5135),('arf','',5136),('ongoing pericardial effusion','',5137),('effusions','',5138),('pulsus parodoxicus','',5139),('lewin','',5140),('pericardial drainage','',5141),('odell','',5142),('fellow','',5143),('air hunger','',5144),('05-28 cxr','',5145),('large pericardial effusion','',5146),('preload','',5147),('dilt','',5148),('additional a fib control','',5149),('robert marks','',5150),('robert fitzgerald','',5151),('a 40-year-old female','',5152),('brothers','',5153),('anginal equivalent','',5154),('cardiac medications','',5155),('asthma attacks','',5156),('benadryl','',5157),('46 - yo-man','',5158),('margaret hallock','',5159),('b. schumacher','',5160),('ken nansteel-miller','',5161),('the triplet #3','',5162),('betamethasone','',5163),('a shortened cervix','',5164),('the babies','',5165),('triplet #3','',5166),('other caregivers','',5167),('cold','',5168),('shivery','',5169),('daughters','',5170),('level','',5171),('paxil','',5172),('elevated fs','',5173),('extubation','',5174),('edmund starke','',5175),('theresa leonore np','',5176),('vasoactive drips','',5177),('loose teeth','',5178),('richard williams','',5179),('this infant','',5180),('non-dysmorphic premature infant','',5181),('weight','',5182),('length','',5183),('head circumference','',5184),('the parents','',5185),('ralph','',5186),('parents','',5187),('her parents','',5188),('glucagon drips','',5189),('cks','',5190),('s. saracino','',5191),('other medications','',5192),('labs','',5193),('this 20 year old driver','',5194),('orthopedics','',5195),('william scheidel','',5196),('head injury','',5197),('mouth-to-mouth resuscitation','',5198),('endurance training','',5199),('overall fluid status','',5200),('hospitalization','',5201),('peggy hammock','',5202),('dusky','',5203),('jule','',5204),('renee','',5205),('a patient','',5206),('dad','',5207),('some discoordination of his suck','',5208),('am hct','',5209),('mdi','',5210),('baseline 02 requirement','',5211),('ace inhibitor','',5212),('severe copd','',5213),('richard , kevin robinson','',5214),('am bp meds','',5215),('hcts','',5216),('bp meds','',5217),('low bp','',5218),('further bp titration','',5219),('mild diarrhea','',5220),('stents','',5221),('guiac positive stools','',5222),('guiac pos stools','',5223),('david , larry robinson','',5224),('leah , paula g. wilson','',5225),('the catheterization','',5226),('brian','',5227),('weak right leg','',5228),('severe dysarthria','',5229),('tpa','',5230),('bipolar disorder','',5231),('home dose of zocor','',5232),('further ischemia','',5233),('gait difficulties','',5234),('previous strokes','',5235),('mr. anders','',5236),('grandfather','',5237),('knee injury','',5238),('orthopaedics','',5239),('knee meniscal tear','',5240),('marion bock','',5241),('larry bock','',5242),('70 y/o f','',5243),('cardiac history','',5244),('gregory,domingo j','',5245),('chf','',5246),('baby girl kathryn frazier','',5247),('joseph clarence','',5248),('74 yo m','',5249),('prior mi','',5250),('the patients','',5251),('prior known imi','',5252),('patients','',5253),('blood pressure meds','',5254),('coumadin level','',5255),('main issue','',5256),('fred grauman','',5257),('cesarean section','',5258),('raymond','',5259),('mr. williams','',5260),('ann j. haley pa','',5261),('mrs. mandelbaum','',5262),('maintenance dose','',5263),('ann kenneth np','',5264),('this 68 year old male','',5265),('left foot ulcer','',5266),('drop','',5267),('ventilator','',5268),('diabetes mellitus','',5269),('foot infection','',5270),('leg ulcer','',5271),('rate','',5272),('zosyn','',5273),('preoperative medications','',5274),('mr. roach','',5275),('intracranial pressure','',5276),('serum osmolalities','',5277),('systemic blood pressures','',5278),('cerebral perfusion pressure','',5279),('clinical examination','',5280),('her peak flows','',5281),('right heart cath','',5282),('a fib','',5283),('monitoring of her electrolytes','',5284),('flaccid right arm','',5285),('a stress test','',5286),('carafate','',5287),('gram-negative rods','',5288),('drain','',5289),('body temperature','',5290),('central venous pressure','',5291),('the surgical','',5292),('resuscitation','',5293),('tracheostomy','',5294),('casting','',5295),('wounds','',5296),('pressors','',5297),('pressure','',5298),('nephrostomy tube','',5299),('rate control','',5300),('richard wanita','',5301),('oxygenation','',5302),('significant infection','',5303),('chronic hypothyroidism','',5304),('increasing shortness of breath','',5305),('42 yom','',5306),('marie','',5307),('bp medications','',5308),('x. neuse','',5309),('patrick','',5310),('coags','',5311),('ifex infusion','',5312),('vp-16','',5313),('count','',5314),('melba barnett','',5315),('bilirubin','',5316),('newborn screens','',5317),('terrance','',5318),('jennifer martin','',5319),('sarah , santo s. isom','',5320),('trach collar','',5321),('nutrition regimen','',5322),('doboff tube','',5323),('poor nutritional status','',5324),('mental status change','',5325),('recent mrsa pneumonia','',5326),('j-tube','',5327),('medication regimen','',5328),('josh harry','',5329),('herself','',5330),('vna','',5331),('pt.','',5332),('victoria','',5333),('aunt','',5334),('echocardiogram study results','',5335),('bennie','',5336),('incisions','',5337),('immunosuppression','',5338),('levophed drip','',5339),('h e','',5340),('seizures','',5341),('lumbar drain','',5342),('head incision','',5343),('head wound','',5344),('wound site','',5345),('neursurg','',5346),('pts','',5347),('a superficial ulcerations on her foot','',5348),('dnr','',5349),('dni','',5350),('henry','',5351),('the patietn','',5352),('initial oxygen sat','',5353),('r heel wound','',5354),('dose','',5355),('ng tube feeds','',5356),('toprol','',5357),('digoxin','',5358),('cardiomyopathy','',5359),('elevated cardiac enzymes','',5360),('elevated wedge pressures','',5361),('right lower lobe infiltrate','',5362),('right heart catheterization','',5363),('biopsy','',5364),('icd placement','',5365),('dnr/dni','',5366),('comfort measures','',5367),('presumed aspiration','',5368),('thoracotomy','',5369),('nephews','',5370),('initial neurologic examination','',5371),('balloon pump','',5372),('bryan smith','',5373),('blood transfusions','',5374),('only yeast source','',5375),('split thickness skin grafts','',5376),('trach','',5377),('pacing lead','',5378),('external pacemaker ddd','',5379),('midabdominal incision','',5380),('jejunostomy tube','',5381),('dialysis','',5382),('albumin','',5383),('a. l. . taylor','',5384),('cd4 count','',5385),('vaccines','',5386),('iv steroids','',5387),('haart regimen','',5388),('teddy stephen','',5389),('new beta blocker','',5390),('low urine output','',5391),('hickman','',5392),('hickman catheter','',5393),('flolan','',5394),('valium','',5395),('facial twitching','',5396),('last mri','',5397),('altered mental status','',5398),('pt/ot','',5399),('kitty pamela np','',5400),('differential','',5401),('next cycle of cvad','',5402),('epidural','',5403),('gestational carrier','',5404),('twins','',5405),('dr. ronald','',5406),('dr. lueras','',5407),('elizabeth f. wells , m.d','',5408),('dr. charles y.s. warnock','',5409),('attending','',5410),('angie cm johnson , m.d.','',5411),('wife','',5412),('father','',5413),('mother','',5414),('physical therapy','',5415),('dr. alvarado','',5416),('dr. mullins','',5417),('your primary care physician / urologist','',5418),('provider','',5419),('bernice jessica md','',5420),('carol lydia md','',5421),('dr. elizabeth gs vega','',5422),('ross z kenmore , m.d.','',5423),('spine','',5424),('dr. rowles','',5425),('his wife','',5426),('children','',5427),('his oncologist','',5428),('dr. scott ann , md','',5429),('dr erb','',5430),('your oncologist','',5431),('brooke donna md','',5432),('jessica pope md','',5433),('dr. maryjane ws hammond','',5434),('terry t trott , m.d.','',5435),('son','',5436),('family','',5437),('her hepatologist','',5438),('dr. steidl','',5439),('her pcp','',5440),('dr. popoff','',5441),('the icu team','',5442),('the family','',5443),('the medical team','',5444),('tracy doris md','',5445),('melvin thomas md','',5446),('dr. micheal j. rozzi','',5447),('the mother','',5448),('the doctor','',5449),('mom','',5450),('twin #1','',5451),('dr. vito dotzler','',5452),('her sister','',5453),('primary pediatrician','',5454),('beverly q. bailey , m.d.','',5455),('carmen y.r. martinez , m.d.','',5456),('dr. lizzie calkins','',5457),('kristie r. hamby , m.d.','',5458),('antonio m. z. eddings , m.d.','',5459),('his pcp','',5460),('lucio y. matthews , m.d.','',5461),('lucio f. r. matthews , m.d.','',5462),('your gastroenterologist','',5463),('alan john md','',5464),('bertha janice motta md','',5465),('dr. melody parks','',5466),('sarah q. george , m.d.','',5467),('daughter','',5468),('a daughter','',5469),('two children','',5470),('dr. jason long','',5471),('the staff radiologist','',5472),('dr. billy l. boender','',5473),('dr. pat k. walton','',5474),('frank linda md','',5475),('deanna patague md','',5476),('dr. marta keever','',5477),('dr. alonso naugle','',5478),('her family','',5479),('this dictator','',5480),('dr. james deighan','',5481),('jason l parra , m.d.','',5482),('dr. wanda parks','',5483),('dr. nicholson','',5484),('her primary care physician','',5485),('thompson ming li , m.d.','',5486),('marcelene r. brennan , m.d.','',5487),('dr. ruth o. black','',5488),('dr. joseph','',5489),('robert mincer , m.d.','',5490),('penny k. mcbride , m.d.','',5491),('dr. kenneth rhein','',5492),('timothy e woolfolk , m.d.','',5493),('robert c. warren , m.d.','',5494),('dr. kevin arthur','',5495),('dr. amanda hilton','',5496),('kevin f juliusson , m.d.','',5497),('by:anita x. duffy , m.d.','',5498),('dr. vanessa riker','',5499),('dr. ______________','',5500),('kathy tillis , m.d.','',5501),('john v.e. jameson , m.d.','',5502),('dr. kathy tillis','',5503),('crystal gq divers , m.d.','',5504),('his surgeon','',5505),('sister','',5506),('brother','',5507),('our','',5508),('our ip team','',5509),('john iris md','',5510),('patricia rojas md','',5511),('dr. john j. booker','',5512),('dr. debra oneal','',5513),('his cardiologist','',5514),('saul n. keehne , m.d.','',5515),('shirley y waler , m.d.','',5516),('dr. william spencer','',5517),('the renal and surgical residents','',5518),('cardiology','',5519),('dr. jones','',5520),('dr. yost','',5521),('dr. miller','',5522),('christina kinde , md','',5523),('by:lillian u walley , m.d.','',5524),('dr. thomas rosier','',5525),('dr. marie anderson','',5526),('dr. ross','',5527),('terry cr dennis , m.d.','',5528),('tracy c rea , m.d.','',5529),('dr. antonio hall','',5530),('gayle m whitener , m.d.','',5531),('urology','',5532),('renal','',5533),('neurosurgery','',5534),('family members','',5535),('husband','',5536),('4 y.o. son','',5537),('the neurology consult service','',5538),('the oncology consult service','',5539),('her outside hematologist dr. pauling','',5540),('dr . pauling','',5541),('jacque john md','',5542),('marcy caroline latham md','',5543),('dr. richard ronald lockett','',5544),('twin a','',5545),('twin b','',5546),('dr. kim adams','',5547),('out of home care givers','',5548),('kurt s imperato , m.d.','',5549),('dr. debbie tran','',5550),('several foster children','',5551),('ear/nose/throat','',5552),('the medical intensive care unit attending','',5553),('visiting nursing','',5554),('dr. jeanette barr','',5555),('james z berg , m.d.','',5556),('melanie l.w. palevic , m.d.','',5557),('dr. andrea trotter','',5558),('derrick l. mayo , m.d.','',5559),('her guardian','',5560),('guardian','',5561),('team','',5562),('the procedure team','',5563),('renal consultants','',5564),('the cmed csru intern','',5565),('cardiology attending','',5566),('the ccu staff','',5567),('jessica ashley md','',5568),('james weishaar md','',5569),('dr. barry smith','',5570),('dr. benson','',5571),('dr. luedeman,melissa','',5572),('andrew c hoffman , m.d.','',5573),('dr. andrew x.. dale','',5574),('daniel z. h. walton , m.d.','',5575),('a new pcp','',5576),('your cardiology','',5577),('dr. villani','',5578),('a primary care physician','',5579),('dr. lesha lefebvre','',5580),('his secretary','',5581),('ralph katherine md','',5582),('terry smith md','',5583),('dr. jennifer applebee','',5584),('ernest k. gardner , m.d.','',5585),('sarah z stephens , m.d.','',5586),('dr. billie schneider','',5587),('dr. penny scott','',5588),('dr. parramore','',5589),('janna l. desorbo , m.d.','',5590),('jeannette d. rede , m.d.','',5591),('dr. bernice jenkins','',5592),('george xl patrick , m.d.','',5593),('his daughter','',5594),('his primary physician','',5595),('your doctor','',5596),('your primary doctor','',5597),('clemmie shawn md','',5598),('michael melvin kinzer md','',5599),('dr. justin pappas','',5600),('luis jg lavoie , m.d.','',5601),('oldest son','',5602),('speech and swallowing','',5603),('dentistry','',5604),('omfs','',5605),('surgeon','',5606),('dr. dewhurst','',5607),('dr. burns','',5608),('chad barbara md','',5609),('dr. eugene offutt','',5610),('richard s. humphries , m.d.','',5611),('friend','',5612),('1st degree relatives','',5613),('primary cardiologist','',5614),('nurses','',5615),('doctors marilyn kristen layne','',5616),('your cardiologist','',5617),('robert melissa md','',5618),('william bennett md','',5619),('dr. evelyn paulk','',5620),('twin number ii','',5621),('twin number i','',5622),('dr. hortencia conner','',5623),('other care givers','',5624),('dr. avon','',5625),('brian lt wentzel , m.d.','',5626),('tammy t.k. farless , m.d.','',5627),('dr. john bonilla','',5628),('michael n sawyer , m.d.','',5629),('rebecca s jefcoat , m.d.','',5630),('dr. dorothy desalvo','',5631),('geoffrey f corney , m.d.','',5632),('primary care doctor','',5633),('your pcp','',5634),('dr. jessie','',5635),('dr. hemler','',5636),('dr. colombo','',5637),('dr. powell','',5638),('james jennifer md , phd','',5639),('kimberly sarah md','',5640),('dr. joanne gilbert yang','',5641),('the orthopedics service','',5642),('neurosurgical service','',5643),('psychiatry','',5644),('the neuro-rehabilitation service','',5645),('his family','',5646),('his mother','',5647),('dr. johnson','',5648),('maria l. bell , m.d.','',5649),('michael x. fisher , m.d.','',5650),('sister-in-law','',5651),('paternal aunt','',5652),('the gestational carrier','',5653),('the contact social worker','',5654),('married , retired accountant','',5655),('james','',5656),('steven welch','',5657),('whose','',5658),('gregory x wingard','',5659),('pat barrow','',5660),('carol robert np','',5661),('mary karina','',5662),('her maternal grandmother','',5663),('liver teams','',5664),('may chen , pa.','',5665),('joanne dennen','',5666),('boyfriend','',5667),('grandmother','',5668),('one-to-one sitter','',5669),('johannes','',5670),('scott robert np','',5671),('here','',5672),('justin searle','',5673),('rau','',5674),('mark yvonne np','',5675),('juanita','',5676),('the physical therapist','',5677),('electrician','',5678),('reyes marengo pa','',5679),('cardiololgy','',5680),('agachbrauch , rensiaanarc','',5681),('clozluin , noshin','',5682),('rathelife , tieanaki b','',5683),('trosprob , styees','',5684),('cienne , gutaoi','',5685),('elksobebeuch , ieve','',5686),('elksfalcbainkih , on','',5687),('burltis trowelks','',5688),('wierstkotea , jeta','',5689),('trowelks , burltis','',5690),('smantverge , tawnen','',5691),('vonnelibry pousscrookesseille','',5692),('trosgaugh , nacole','',5693),('pousscrookesseille , vonnelibry','',5694),('pruesschird , riie','',5695),('toob i obestimeuph','',5696),('zeisrhaltprot , quetsha','',5697),('biri weertluc','',5698),('asquarcelmes , norobeber','',5699),('weertluc , biri','',5700),('drs. freierm','',5701),('round','',5702),('duhetland , rie','',5703),('amine guaytreftscost','',5704),('puleshuff , saca g','',5705),('guaytreftscost , amine','',5706),('getzzochtland , synnani f','',5707),('rhaltheagle , leelo','',5708),('his pmd','',5709),('tlandrac , ni','',5710),('breunlinke','',5711),('nertland','',5712),('akote , ralpri','',5713),('chird , grajord c','',5714),('ftloyd , lette d','',5715),('kayskudz , naro','',5716),('name','',5717),('elkschird , eberta r','',5718),('aascoleslent , dirod','',5719),('rybam shoulder','',5720),('douet , lah','',5721),('shoulder , rybam','',5722),('trouitsa , win','',5723),('-the pt','',5724),('ri strength','',5725),('tricheprakejesc , betla','',5726),('2 daughters','',5727),('ryrol daledae , np','',5728),('ralnmottefuh , aeen','',5729),('wyndealb , auale','',5730),('state , elro','',5731),('nieie naebrand freierm','',5732),('falmdrepsgrend , line','',5733),('shuffcuch , seysharmse n','',5734),('rallsversgach , dwainco','',5735),('ertca dirk','',5736),('sligh','',5737),('saujule study','',5738),('douetnounbreunkoll , stenreslyse','',5739),('dalejesc , oie','',5740),('breutzfreierm , viennee','',5741),('the dietician','',5742),('jemskop , cot','',5743),('kotedaizreke , lila','',5744),('titcheagnero , to','',5745),('older , black gentleman','',5746),('uph , jim','',5747),('asha vengloan','',5748),('vengloan , asha','',5749),('liley , peantsall','',5750),('mong , rishrieli','',5751),('ica gachcienne','',5752),('kotefooks , dasha','',5753),('lette , vita n','',5754),('jaquenathe , mya','',5755),('crutch , naeelv','',5756),('fyfevaia , lorerindil','',5757),('ch kotekoll','',5758),('sumchirdkaysmavveindreps , yertrey','',5759),('kotekoll , ch','',5760),('child','',5761),('fyfeuardfel , tade','',5762),('fong , coney n','',5763),('glyn , aea','',5764),('linkethore , hansverllen g','',5765),('swankemandesskiais , santcinet e','',5766),('xieacass bethconri balloon','',5767),('polle , nella o','',5768),('lenkpruskihkooglekih , niekero c','',5769),('obefyfe , tree','',5770),('guynlordsmantdouet , aryriste t','',5771),('ldamc','',5772),('knolesa , via','',5773),('inachelle breutzbreunbreuncotfalke','',5774),('leebkayshaupkerth , maenzet n','',5775),('breutzbreunbreuncotfalke , inachelle','',5776),('fyfewierst , mier','',5777),('call , granrivern s','',5778),('granrivern call','',5779),('the examiner','',5780),('breunclontstreauayles , bintriree','',5781),('50 yo m','',5782),('selcfarst , naorly','',5783),('guynlordsmantdouet , ryla b','',5784),('sours , nanoniff ellmi','',5785),('lichereanyve chirdkotekerth','',5786),('clev , nisha','',5787),('chirdkotekerth , lichereanyve','',5788),('caugh , di k','',5789),('hempwierst , e','',5790),('glotzasrhalt , shirlh','',5791),('gram meedner','',5792),('meedner , shaza','',5793),('mrs. dua','',5794),('the ot / pt dept.','',5795),('riashwan berlni valley','',5796),('fyfe , lan s','',5797),('akotebontkays , juanquintleo','',5798),('aner , aea m','',5799),('koorskote , retco','',5800),('he herdes','',5801),('kotekotepruess , susnum','',5802),('herdes , newshalie','',5803),('scobe , rylalon','',5804),('brittsfyfeast , sher t','',5805),('neighroblin , rette r','',5806),('jem , on','',5807),('ackca , slaineaee l','',5808),('ackca , slaineaee l','',5809),('chirdvoln , iena','',5810),('age shuff','',5811),('shuff , ronrin','',5812),('shuff , ronrin','',5813),('shuff , ronrin','',5814),('koterostreukote , aro ma o.','',5815),('houghtbreun','',5816),('houghtbreun','',5817),('houghtbreun , tesant e.','',5818),('kulrinne , ryyelege n','',5819),('kulrinne , ryyelege n','',5820),('kulrinne , ryyelege n','',5821),('kotejoasthoreuphkays','',5822),('chaffbitz , li','',5823),('newborn','',5824),('preheprior , nienemileisele','',5825),('preheprior , nienemileisele','',5826),('shuffjesc , nanora','',5827),('queloisevier dreweilltrievkemme','',5828),('queloisevier dreweilltrievkemme','',5829),('wires , peantsall a','',5830),('dreweilltrievkemme , queloisevier','',5831),('dreweilltrievkemme , queloisevier','',5832),('slentpeasebumps , lisssond','',5833),('slentpeasebumps , lisssond','',5834),('slentpeasebumps , lisssond','',5835),('slentpeasebumps , lisssond','',5836),('apt shuff','',5837),('clopkoorsfongayles , norbmade','',5838),('jesccot , la p. , c.n.m','',5839),('kote , yga','',5840),('a , walina','',5841),('pada meedhuang','',5842),('white , elvno r','',5843),('meedhuang , pada','',5844),('critche , nifrededrhet','',5845),('dreissneigh , liru','',5846),('chaffbitz , tessmondmarv','',5847),('gastrointestinal','',5848),('gastrointestinal','',5849),('gastrointestinal','',5850),('gastrointestinal','',5851),('gastrointestinal','',5852),('gastrointestinal','',5853),('gastrointestinal','',5854),('wierstuph , norname h','',5855),('wierstuph , norname h','',5856),('maternal grandfather','',5857),('maternal grandfather','',5858),('akote , nao','',5859),('freiermpratl , ni l','',5860),('wwww','',5861),('wwww','',5862),('wwww','',5863),('hhhhhhh','',5864),('drs. eeeee','',5865),('drs. eeeee','',5866),('drs. eeeee','',5867),('drs. eeeee','',5868),('drs. eeeee','',5869),('drs. eeeee','',5870),('one','',5871),('the gastroenterologists','',5872),('the gastroenterologists','',5873),('bbbbbbbbbbbb','',5874),('bbbbbbbbbbbb','',5875),('the attendant','',5876),('well-developed, well-nourished individual','',5877),('mrs. bbbbb','',5878),('them','',5879),('mrs. ccccccccccccccccccc','',5880),('a homemaker','',5881),('mmmmmmm','',5882),('mrs. aaaaaa','',5883),('mrs. eeeee','',5884),('ent','',5885),('reke , atota s','',5886),('breundail , netfa','',5887),('**name[vvv uuu]','',5888),('her fiance','',5889),('**name[xxx , www]','',5890),('**name[xxx , www]','',5891),('**name[zzz , yyy]','',5892),('**name[www xxx]','',5893),('maulplackagneleeb , inachelle','',5894),('space , dota','',5895),('thon meri cinkguay','',5896),('thon meri cinkguay','',5897),('**name[aaa , bbb m]','',5898),('**name[yyy xxx zzz]','',5899),('**name[www , sss]','',5900),('**name[yyy zzz]','',5901),('**name[yyy zzz]','',5902),('**name[aaa , bbb]','',5903),('attend','',5904),('**name[aaa]','',5905),('**name[aaa , m m]','',5906),('**name[yyy m] jr','',5907),('**name[zzz]','',5908),('**name[uuu]','',5909),('**name[www xxx] , r.n.','',5910),('-**name[xxx , ttt]','',5911),('**name[yyy zzz] jr','',5912),('dict','',5913),('the intensivist','',5914),('physical therapist','',5915),('occupational therapist','',5916),('the medics','',5917),('residents','',5918),('this gentleman','',5919),('home health','',5920),('cardiovascular','',5921),('author','',5922),('consultants','',5923),('consultant','',5924),('her power of attorney','',5925),('metlife','',5926),('a representative','',5927),('dentist','',5928),('behavioral health','',5929),('microbiology','',5930),('consults','',5931),('the neurologic consultant','',5932),('another jet skater','',5933),('the orthopedic office','',5934),('the er','',5935),('a chiropractor','',5936),('a pco','',5937),('cardiac rehab','',5938),('this elderly gentleman','',5939),('his cellmate','',5940),('s carlberg','',5941),('psych','',5942),('crnp','',5943),('m.d.-thomas d. ***','',5944),('028200-painter , m.d.-thomas d.','',5945),('her poa','',5946),('ophthlologist','',5947),('poa','',5948),('ortho','',5949),('assisstent','',5950),('this pt','',5951),('plastic','',5952),('yyy m zzz]','',5953),('theirs','',5954),('**age[in 70s] yo veteran','',5955),('**age[in 70s] yo wm','',5956),('her neighboors','',5957),('neighbors','',5958),('pat.','',5959),('social services','',5960),('nsg','',5961),('the nicu','',5962),('name[aaa, bbb m','',5963),('name[aaa, bbb m','',5964),('name[aaa, bbb m','',5965),('name[aaa, bbb m','',5966),('name[aaa, bbb m','',5967),('name[aaa, bbb m','',5968),('name[yyy m zzz','',5969),('name[yyy m zzz','',5970),('the ed','',5971),('a healthy volunteer','',5972),('pancreaticobiliary','',5973),('the sleep  lab','',5974),('a student','',5975),('a student','',5976),('waresin , sagay','',5977),('breana g. cornea , m.d.*','',5978),('mrs. tttttt','',5979),('neuro','',5980),('a sitter','',5981),('dr.parson','',5982),('maria scheer','',5983),('triplet number two','',5984),('this triplet','',5985),('triplet number one','',5986),('triplet number three','',5987),('strickland','',5988),('two sisters','',5989),('six brothers','',5990),('frederick tracey','',5991),('anthony mcknight','',5992),('mark eugene np','',5993),('72 yo m','',5994),('trauma','',5995),('pedestrian','',5996),('christopher sandy np','',5997),('cardiothoracic','',5998),('jerry pamela np','',5999),('omalley','',6000),('social work','',6001),('jeremy n. p. moschella pa','',6002),('47 yo f','',6003),('robert burger','',6004),('sheena','',6005),('freirekote , sonyla','',6006),('reefraup , ja y','',6007),('mychelia','',6008),('endocrine','',6009),('a maternal cousin','',6010),('gardner state hospital social worker','',6011),('the contact','',6012),('ashley daley','',6013),('out of home caregivers','',6014),('rosalie gloria','',6015),('addiction services','',6016),('sandra rose','',6017),('pmd','',6018),('sick contact','',6019),('joann','',6020),('dunn , rachel finch','',6021),('mary powell','',6022),('leona wheeler','',6023),('many siblings','',6024),('multiple siblings','',6025),('stella , kendra b .','',6026),('the two teams','',6027),('brandon','',6028),('pocasset','',6029),('tai pamela christopher','',6030),('10 month old child','',6031),('lori harwood','',6032),('daniel crump','',6033),('helen cynthia','',6034),('57 y/o f','',6035),('57 yo f','',6036),('dianne white','',6037),('neonatology','',6038),('david bull','',6039),('jadiara','',6040),('albano','',6041),('trasplant','',6042),('thomasine','',6043),('mr stutts','',6044),('ethics services','',6045),('her daughters','',6046),('two daughters','',6047),('her endocrinologist','',6048),('hcp','',6049),('his companion','',6050),('two grandson','',6051),('glenn shives','',6052),('his significant other','',6053),('michael edwards','',6054),('both parents','',6055),('evelyn matos','',6056),('david','',6057),('the person','',6058),('mrs. gonzalez','',6059),('home pt','',6060),('a arbour hospital social worker','',6061),('contact social worker','',6062),('claire','',6063),('dr.hastings','',6064),('hale air force base pediatrics','',6065),('preschool age siblings','',6066),('otolaryngology','',6067),('assistant','',6068),('patricia jackson','',6069),('nola daniel','',6070),('mrs. wisniewski','',6071),('roderick','',6072),('a asian interpreter','',6073),('larry','',6074),('andrea','',6075),('covering intern','',6076),('ms crossman','',6077),('amy','',6078),('sandra','',6079),('kimberly','',6080),('her child','',6081),('attendings','',6082),('ginslent , a l','',6083),('kote , lyfranklapalm','',6084),('scimewhildajesc , la r','',6085),('boormkaysscaje , pa a.','',6086),('her first child','',6087),('a maternal uncle','',6088),('maternal aunt','',6089),('schoellsullkotefong , maustinie','',6090),('schoellsullkotefong , maustinie','',6091),('gento yaneslaunt','',6092),('gento yaneslaunt','',6093),('arois maillliepslighsint','',6094),('kotebitzweerts , lixyna n','',6095),('lilletlandtriev , roseen ertondon','',6096),('gach , ch','',6097),('netshuffscarvtrace , rira','',6098),('a , rebay j','',6099),('a , rebay j','',6100),('katesjesc , rai','',6101),('kayslance , iceroyln','',6102),('heagleinchird , jeansia s','',6103),('his neighbors','',6104),('the paramedics','',6105),('his next of kin','',6106),('next of kin','',6107),('the presidents','',6108),('carter-bush-regan-truman-roosevelt','',6109),('hibbskote , sialind','',6110),('freiermdreps , ri','',6111),('ronrin shuff','',6112),('credkote , alen','',6113),('douettwidouet , taroby','',6114),('sapsclyss , leo r','',6115),('his orthopedist','',6116),('meedheyskudzro , leenlee c','',6117),('67 y/o f','',6118),('cardiac surgical','',6119),('brenoce , t n','',6120),('strapefreire , vataly c','',6121),('kotenort , oan r','',6122),('vessels , tistie d','',6123),('factor , rebem','',6124),('crassbelbkote , nee','',6125),('his health-care proxy','',6126),('duldkote , ei n','',6127),('fyfereoskote , cillma m','',6128),('less , lieseanale','',6129),('mrs. less','',6130),('hauth','',6131),('a , mifer','',6132),('koorskote , shara g','',6133),('kote , oa','',6134),('mrs. cast','',6135),('neuro-ophthalmology','',6136),('jergjesc , grosrianne sisandlee','',6137),('stenobe , landem','',6138),('your obstetrician','',6139),('obstetrician','',6140),('freiermlinkeneighcaablinfarst , anea','',6141),('allergy','',6142),('boehkote , sona s','',6143),('sterpkoteneish , lydell a','',6144),('rhaltdealbbreutz , sta','',6145),('tubbolm , lisswhiti n','',6146),('ajesc , darlma margea l','',6147),('falc , coll','',6148),('smoking cessation group','',6149),('the smoking cessation program','',6150),('thaa wages','',6151),('anerm , chretta','',6152),('two people','',6153),('the swallowing therapist','',6154),('junk , kacholera','',6155),('wiegneigh , yla','',6156),('nique , toya n','',6157),('yertrey sumchirdkaysmavveindreps','',6158),('slandtif , astheo d','',6159),('spaldfreiermplca , ieoly e','',6160),('/pcp','',6161),('die anoort','',6162),('american','',6163),('multiple sexual partners','',6164),('an interpreter','',6165),('koteharbe , thryne','',6166),('fyfezeisleitz , mata','',6167),('houghtjescslem , rieshinjin r','',6168),('jescwierst , ma','',6169),('priesdouet , ch j','',6170),('grendziskleeb , facisa t','',6171),('juarisy duhesmitre','',6172),('thorerogodlethrelf , cisperna m','',6173),('cuchspardcampmottelamn , larin','',6174),('va lardesprableyl','',6175),('gynecologist','',6176),('lardesprableyl , va','',6177),('obstetrical','',6178),('ockgiernruss , riret r','',6179),('ockgiernruss , riret r','',6180),('giengbeenea , naa','',6181),('gyn / onc','',6182),('second , ca','',6183),('sterpmoone , ny','',6184),('nonok ayrekempe','',6185),('therapist','',6186),('ayrekempe , nonok','',6187),('thoracic surgical','',6188),('his girlfriend','',6189),('phyisican','',6190),('meals on wheels','',6191),('paramedics','',6192),('the neighbors','',6193),('consulting physicians:','',6194),('whom','',6195),('themselves','',6196),('the police','',6197),('a diabetic educator','',6198),('oculoplastic','',6199),('coordinator','',6200),('the clinic coordinator','',6201),('rehab','',6202),('your coordinator','',6203),('zzz','',6204),('yyy] c','',6205),('homecare','',6206),('his group','',6207),('pulmonology','',6208),('surgical','',6209),('the people','',6210),('someone','',6211),('the va hospital administrators','',6212),('housestaff','',6213),('**age[in 70s] y/o f','',6214),('her ','',6215),('the present of usa','',6216),('**age[in 20s] yo','',6217),('discharge planning','',6218),('**age[in 80s]yo m','',6219),('**age[in 40s] yo f','',6220),('rheum','',6221),('zzz m yyy]','',6222),('intern','',6223),('derm','',6224),('cards','',6225),('83yo f','',6226),('83yo f','',6227),('83yo f','',6228),('83yo f','',6229),('83yo f','',6230),('nerslet , beriss','',6231),('nerslet , beriss','',6232),('rosorb , asaleysean i','',6233),('joas , ceni , c.n.m.','',6234),('joas , ceni , c.n.m.','',6235),('joas , ceni , c.n.m.','',6236),('joas , ceni , c.n.m.','',6237),('miss siehjesc','',6238),('cachectic malnourished edematous individuals','',6239),('netpeake , shirlh','',6240),('kotea , tortheoa','',6241),('wages , thaa','',6242),('a well-developed , well-nourished gentleman','',6243),('a well-developed , well-nourished gentleman','',6244),('a well-developed , well-nourished gentleman','',6245),('sc , jusonkim n','',6246),('sc , jusonkim n','',6247),('shuffneg , soa w','',6248),('shuffneg , soa w','',6249),('shuffneg , soa w','',6250),('shuffneg , soa w','',6251),('shuffneg , soa w','',6252),('shuffneg , soa w','',6253),('ponzer','',6254);
/*!40000 ALTER TABLE `queries` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-09-02 15:33:23
