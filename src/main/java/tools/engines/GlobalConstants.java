/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools.engines;

/**
 * These are constants that are referenced globally, i.e., by more than one module.
 */
public class GlobalConstants {
   // miscellany
   public static final String DEFAULT_PLATFORM_BASE_DIR = "/var/lib/rs/dataplatform/"; // NOTE: this path must end with a directory separator char
   public static final String DEFAULT_PLATFORM_LOGS_DIR = DEFAULT_PLATFORM_BASE_DIR + "logs/"; // NOTE: this path must end with a directory separator char
   public static final String DEFAULT_PLATFORM_CONFIG_DIR = DEFAULT_PLATFORM_BASE_DIR + "config/"; // NOTE: this path must end with a directory separator char
   public static final String DEFAULT_PLATFORM_BIN_DIR = DEFAULT_PLATFORM_BASE_DIR + "bin/"; // NOTE: this path must end with a directory separator char
   public static final String DEFAULT_TOPOLOGIES_BIN_DIR = DEFAULT_PLATFORM_BIN_DIR + "topologies/"; // NOTE: this path must end with a directory separator char
   public static final String DEFAULT_PLATFORM_EXTENSIONS_DIR = DEFAULT_PLATFORM_BASE_DIR + "extensions/"; // NOTE: this path must end with a directory separator char
   public static final String DEFAULT_TOPOLOGIES_CONFIG_DIR = DEFAULT_PLATFORM_CONFIG_DIR + "topologies/"; // NOTE: this path must end with a directory separator char
   public static final String DEFAULT_PLATFORM_CONFIG_FILE = DEFAULT_PLATFORM_CONFIG_DIR + "dataplatformpodconfig.json";
   public static final String DEFAULT_PLATFORM_SERVICES_FOLDER = "/services";
   public static final String DEFAULT_PLATFORM_MESSAGES_FOLDER = "/messages";
   public static final String RDP_TENANT = "dataplatform";
   public static final String CONTEXT_DELIMITER = "/";
   public static final String CLASSIFICATION_ROOT_ID = "_root";
   public static final int HTTP_SERVER_CONNECTION_TIMEOUT = 10 * 60 * 1000;
   public static final int HTTP_SERVER_REQUEST_TIMEOUT = 5 * 60 * 1000;
   public static final int HTTP_SERVER_REQUEST_LONG_RUNNING = 1000;
   public static final int HTTP_SERVER_METRICS_CHECK_INTERVAL = 60 * 1000;
   public static final int HTTP_SERVER_MAX_PENDING_TASKS = 80;
   public static final long MAX_RESULT_WINDOW_SIZE = 30000;
   public static final String SOFT_DELETE = "softDelete";
   public static final String SOFT_DELETE_PREFIX = "delete";
   public static final String MODEL_ZOOKEEPER_NODE = "/consumers/riversand/model";
   public static final String CONFIG_ZOOKEEPER_NODE = "/consumers/riversand/config";
   public static final String ARTIFACTS_ZOOKEEPER_NODE = "/consumers/riversand/artifacts";
   public static final String ENABLED = "enabled";
   public static final String CONFIG_CACHE_INCLUSION_TYPES = "configCacheInclusionTypes";
   public static final String KEYWORD_CONFIG_OBJECT_TYPE="keywordConfig";
   public static final String BINARY_OBJECT_REFERENCE = "binaryObjectReference";
   public static final String BLOB_REFERENCE_ID = "blobReferenceId";

   // names of our message broker (Kafka) domains
   public static final String MESSAGE_BROKER_DOMAIN_SCHEDULE_OBJECT_MANAGE = "scheduleobject";
   public static final String MESSAGE_BROKER_DOMAIN_CONFIGURATION_MANAGE = "configurationmanage";
   public static final String MESSAGE_BROKER_DOMAIN_ADMIN_MANAGE = "adminmanage";
   public static final String MESSAGE_BROKER_DOMAIN_ADMIN_OBJECT = "adminobject";
   public static final String MESSAGE_BROKER_DOMAIN_BINARY_OBJECT = "binaryobject";
   public static final String MESSAGE_BROKER_DOMAIN_BINARY_STREAM_OBJECT = "binarystreamobject";
   public static final String MESSAGE_BROKER_DOMAIN_ENTITY = "entity";
   public static final String MESSAGE_BROKER_DOMAIN_SNAPSHOT = "snapshot";
   public static final String MESSAGE_BROKER_DOMAIN_ENTITY_GOVERN_EVENT = "entitygovernevent";
   public static final String MESSAGE_BROKER_DOMAIN_ENTITY_GRAPH_EVENT = "entitygraphevent";
   public static final String MESSAGE_BROKER_DOMAIN_ENTITY_MANAGE_EVENT = "entitymanageevent";
   public static final String MESSAGE_BROKER_DOMAIN_BINARY_STREAM_OBJECT_EVENT = "binarystreamobjectevent";
   public static final String MESSAGE_BROKER_DOMAIN_EXTERNAL_EVENT = "externalevent";
   public static final String MESSAGE_BROKER_DOMAIN_ENTITY_POST_PROCESS_EVENT = "entitypostprocessevent";
   public static final String MESSAGE_BROKER_DOMAIN_ERROR_INTERNAL_EVENT = "errorinternalevent";
   public static final String MESSAGE_BROKER_DOMAIN_ERROR_EVENT = "errorevent";
   public static final String MESSAGE_BROKER_DOMAIN_ENTITY_MANAGE_MODEL = "entitymanagemodel";
   public static final String MESSAGE_BROKER_DOMAIN_ENTITY_MANAGE_MODEL_EVENT = "entitymanagemodelevent";
   public static final String MESSAGE_BROKER_DOMAIN_INTERNAL_EVENT = "internalevent";
   public static final String MESSAGE_BROKER_DOMAIN_REQUEST_ENTITY = "requestentity";
   public static final String MESSAGE_BROKER_DOMAIN_EVENT_REPORT = "eventreport";
   public static final String MESSAGE_BROKER_DOMAIN_NOTIFICATION_EVENT = "notificationevent";
   public static final String MESSAGE_BROKER_DOMAIN_GENERIC_OBJECT = "genericobject";
   public static final String MESSAGE_BROKER_DOMAIN_GRAPH_SOURCE = "graphsource";
   public static final String MESSAGE_BROKER_DOMAIN_GRAPH_TARGET = "graphtarget";
   public static final String ENABLE_SYSTEM_INBOUND_TOPIC_TYPE = "enableSystemInboundTopicType";
   public static final String ENABLE_BULK_INBOUND_TOPIC_TYPE = "enableBulkInboundTopicType";
   public static final String ENABLE_BULK_SYSTEM_INBOUND_TOPIC_TYPE = "enableBulkSystemInboundTopicType";
   public static final String ENABLE_UI_BULK_INBOUND_TOPIC_TYPE = "enableUIBulkInboundTopicType";
   public static final String ENABLE_UI_BULK_SYSTEM_INBOUND_TOPIC_TYPE = "enableUIBulkSystemInboundTopicType";
   public static final String ENABLE_HOTLINE_INBOUND_TOPIC_TYPE = "enableHotlineInboundTopicType";
   public static final String ENABLE_MIGRATE_INBOUND_TOPIC_TYPE = "enableMigrateInboundTopicType";
   public static final String ENABLE_EVENT_OUTBOUND_TOPIC_TYPE = "enableEventOutboundTopicType";
   public static final String ENABLE_BULK_SYSTEM_GROOMING_INBOUND_TOPIC_TYPE = "enableBulkSystemGroomingInboundTopicType";

   public static final String ENTITY_GOVERN = "entityGovern";
   public static final String ENABLE_POSTPROCESS_ONLY_FOR_WORKFLOW = "enablePostprocessOnlyForWorkflow";

   // names of our Kafka topics
   public static final String MESSAGE_BROKER_TOPIC_INBOUND = "inboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_SYSTEM_INBOUND = "systemInboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_HOTLINE_INBOUND = "hotlineInboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_MIGRATE_INBOUND = "migrateInboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_BULK_INBOUND = "bulkInboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_BULK_SYSTEM_INBOUND = "bulkSystemInboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_UI_BULK_INBOUND = "uiBulkInboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_UI_BULK_SYSTEM_INBOUND = "uiBulkSystemInboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_OUTBOUND = "outboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_EVENT_OUTBOUND = "eventOutboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_ERROR_OUTBOUND = "errorOutboundTopic";
   public static final String MESSAGE_BROKER_TOPIC_BULK_SYSTEM_GROOMING_INBOUND = "bulkSystemGroomingInboundTopic";

   // data object types
   public static final String DATA_OBJECT_ENTITY_GOVERN_EVENT = "entitygovernevent";
   public static final String DATA_OBJECT_ENTITY_MANAGE_EVENT = "entitymanageevent";
   public static final String DATA_OBJECT_BINARY_STREAM_OBJECT_MANAGE_EVENT = "binarystreamobjectevent";
   public static final String DATA_OBJECT_ENTITY_POST_PROCESS_EVENT = "entitypostprocessevent";
   public static final String DATA_OBJECT_ENTITY_MODEL_EVENT = "entitymodelevent";
   public static final String DATA_OBJECT_CONFIG_MANAGE_EVENT = "configobjectmanageevent";
   public static final String NOTIFICATION_DATA_OBJECT_TYPE = "notificationObject";
   public static final String EMAIL_OBJECT_TYPE = "emailObject";
   public static final String DIGEST_EMAIL_IDENTIFY_REQUEST_OBJECT_TYPE = "digestEmailIdentifyRequestObject";
   public static final String DIGEST_EMAIL_EXECUTE_REQUEST_OBJECT_TYPE = "digestEmailExecuteRequestObject";
   public static final String DIGEST_EMAIL_OBJECT_TYPE = "digestEmailObject";
   public static final String DATA_OBJECT_EXTERNAL_EVENT = "externalevent";
   public static final boolean IS_SORT_VALIDATION_ENABLED = false;

   public static final String ENABLE_TASK_SUMMARIZATION = "enableTaskSummarization";

   public static final String DATE_TIME_FORMATTER_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
   public static final String DATE_FORMATTER_PATTERN = "yyyy-MM-dd";
   public static final String DEFAULT_ROOT_RELATIONSHIP = "belongstoroot";
   public static final String ENHANCER_ROOT_RELATIONSHIP = "enhancerroot";
   public static final String BELONGS_TO_RELATIONSHIP = "belongsto";
   public static final String IS_MIGRATION_ENABLED = "isMigrationEnabled";
   public static final String IS_EVENT_PERSISTENCE_ENABLED = "isEventPersistenceEnabled";
   public static final String IS_OBJECT_STORE_PERSISTENCE_ENABLED = "isObjectStorePersistenceEnabled";
   public static final String IS_REFERENCE_RESOLUTION_ENABLED = "isReferenceResolutionEnabled";

   // notification related
   public static final String TASK_TYPE = "taskType";
   public static final String COP_INTEGRATION_TYPE = "connectIntegrationType";
   public static final String MODEL_IMPORT_TASK = "MODEL_IMPORT";
   public static final String ENTITY_EXPORT_TASK = "ENTITY_EXPORT";
   public static final int DEFAULT_BATCH_SIZE = 1000;
   public static final String VARIANT_GENERATION_EVENT = "variantgenerationevent";
   public static final String TASK_OF_TASKS = "taskOfTasks";
   public static final String RECORD_COUNT = "recordCount";

   //This value has to be compared without ignoring the case
   public static final String NULL_VALUE = "_NULL";

   public class PropertyNames {
      // General properties
      public static final String ALIAS_NAME = "alias";
      public static final String ATTRIBUTES = "attributes";
      public static final String ATTRIBUTE_NAME = "attributeName";
      public static final String PREVIOUS_VALUE = "previous-";
      public static final String ATTRIBUTE_PATH = "attributePath";
      public static final String ATTRIBUTE_Type = "attributeType";
      public static final String ATTRIBUTE_IDENTIFIER = "isAttributeIdentifier";
      public static final String ACTION = "action";
      public static final String ALL_PLACEHOLDER = "_ALL";
      public static final String CHANGE_CONTEXT = "changeContext";
      public static final String CHANGE_TYPE = "changeType";
      public static final String CONTEXT_ADD_ATTRIBUTE_TO_CONTEXTGROUP = "addAttributeToContext";
      public static final String CONTEXT_DELETE_ATTRIBUTE_FROM_CONTEXTGROUP = "deleteAttributeFromContext";
      public static final String CONTEXT_ADD_ATTRIBUTE_TO_RELATIONSHIP = "addAttributeToRelationship";
      public static final String CONTEXT_ADD_RELATIONSHIP_TO_CONTEXTGROUP = "addRelationshipToContext";
      public static final String CONTEXT_DELETE_ATTRIBUTE_FROM_RELATIONSHIP = "deleteAttributeFromRelationship";
      public static final String CONTEXT_DELETE_RELATIONSHIP_FROM_CONTEXTGROUP = "deleteRelationshipFromContext";
      public static final String CONTEXT_UPDATE_ATTRIBUTE = "updateAttributeInContext";
      public static final String CONTEXT_UPDATE_RELATIONSHIP_ATTRIBUTE = "updateAttributeInRelationship";
      public static final String CONTEXT = "context";
      public static final String CONTEXTS = "contexts";
      public static final String CONTEXT_PATH = "ctxPath";
      public static final String CONTEXT_MASHUP = "contextMashup";
      public static final String CONTEXT_COUNT = "contextCount";
      public static final String CONTEXT_TO_ADD = "addContext";
      public static final String CONTEXT_TO_UPDATE = "updateContext";
      public static final String CONTEXT_TO_DELETE = "deleteContext";
      public static final String CONTEXT_DELETE_OBJECT = "deleteDataObject";
      public static final String CONTEXT_TYPE = "ctxType";
      public static final String DATA = "data";
      public static final String DATA_TYPE = "dataType";
      public static final String DATA_OBJECT_ID = "dataObjectId";
      public static final String DATA_OBJECT_DOMAIN = "dataObjectDomain";
      public static final String DATA_OBJECT_SOURCE = "dataObjectSource";
      public static final String DATA_OBJECT_SOURCES = "dataObjectSources";
      public static final String DATA_OBJECT_INFO = "dataObjectInfo";
      public static final String DATA_OBJECT_TYPE = "dataObjectType";
      public static final String DATA_OBJECT_TYPES = "dataObjectTypes";
      public static final String EVENT_TYPE = "eventType";
      public static final String EVENT_SUB_TYPE = "eventSubType";
      public static final String GROUP = "group";
      public static final String GOVERN_CHANGE_CONTEXT = "governChangeContext";
      public static final String ORIGINAL_DATA = "originalData";
      public static final String ID = "id";
      public static final String IDS = "ids";
      public static final String IS_REFERENCE_TYPE = "isReferenceType";
      public static final String MODEL_CHANGE_CONTEXT = "modelChangeContext";
      public static final String MANAGE_CHANGE_CONTEXT = "manageChangeContext";
      public static final String MATCH_SEQUENCE = "matchSequence";
      public static final String MATCH_TYPE = "matchType";
      public static final String MATCH_THRESHOLDS = "matchThresholds";
      public static final String MERGE_THRESHOLD = "mergeThreshold";
      public static final String CREATE_THRESHOLD = "createThreshold";
      public static final String MATCH = "match";
      public static final String NAME = "name";
      public static final String EXCLUDE_NON_CONTEXTUAL = "excludeNonContextual";
      public static final String NON_CONTEXTUAL = "nonContextual";
      public static final String ALL_CONTEXTUAL = "allContextual";
      public static final String OWNERSHIP_DATA = "ownershipData";
      public static final String OWNERSHIP_EDIT_DATA = "ownershipEditData";
      public static final String PROPERTIES = "properties";
      public static final String REF_ENTITY_TYPE = "refEntityType";
      public static final String REFERENCE_DATA = "referenceData";
      public static final String REFERENCE_DATA_IDENTIFIER = "referenceDataIdentifier";
      public static final String REFERENCE_ENTITY_INFO = "referenceEntityInfo";
      public static final String RELATIONSHIPS = "relationships";
      public static final String RELATIONSHIP_ATTRIBUTES = "relationshipAttributes";
      public static final String RELATIONSHIP_ATTRIBUTE_PATHS = "relationshipAttributePaths";
      public static final String RELATIONSHIP_TYPE = "relationshipType";
      public static final String RELATIONSHIP_NAME = "relName";
      public static final String RELATIONSHIP_TO = "relTo";
      public static final String RELATIONSHIP_PATH = "relPath";
      public static final String SEARCH_QUERY = "searchQuery";
      public static final String SEARCH_TEMPLATE_PARAMS = "searchTemplateParamsString";
      public static final String SERVICE_NAME = "serviceName";
      public static final String DOMAIN_NAME = "domain";
      public static final String SOURCE_TIMESTAMP = "sourceTimestamp";
      public static final String TIMESTAMP = "timestamp";
      public static final String TENANT_ID = "tenantId";
      public static final String TYPE = "type";
      public static final String VALUES = "values";
      public static final String VALUE_CONTEXT = "valContext";
      public static final String VALUE = "value";
      public static final String ORIGINATING_SOURCE = "os";
      public static final String ORIGINATING_SOURCE_ID = "osid";
      public static final String ORIGINATING_SOURCE_TYPE = "ostype";
      public static final String VALUE_REFERENCE_ID = "valueReferenceId";
      public static final String UNASSIGNED_USER_ID = "_UNASSIGNED";

      //CV3 attribues
      public static final String ENHANCER_ATTRIBUTES = "enhancerAttributes";
      public static final String ENHANCER_ATTRIBUTE_NAME = "enhancerAttributeName";
      public static final String ENHANCER_ENTITY_TYPE = "enhancerEntityType";
      public static final String ENHANCER_RELATIONSHIP_PATH = "pathRelationship";
      public static final String ENHANCER_PRIORITY = "priority";
      public static final String CONTEXT_LEVEL = "level";
      public static final String CONTEXT_KEY = "contextKey";
      public static final String CONTEXT_RELATIONSHIP = "contextRelationship";
      public static final String PARENT_CONTEXT_KEY = "parentContextKey";

      // Govern object related properties
      public static final String MESSAGES = "messages";
      public static final String RULES_RUN = "rulesRun";
      public static final String MESSAGE_TYPE = "messageType";
      public static final String MESSAGE_CODE = "messageCode";
      public static final String MESSAGE_PARAMS = "messageParams";
      public static final String STATE = "state";
      public static final String BUSINESS_RULE = "businessRule";
      // Property related properties
      public static final String PROPERTY_NAME = "propertyName";
      public static final String PROPERTY_PATH = "propertyPath";
      public static final String PROPERTY_VALUES = "propertyValues";
      public static final String PROPERTY_VALUE = "propertyValue";
      public static final String BLOB = "blob";
      public static final String DEFAULT_DATA_TYPES = "defaultDataTypes";
      public static final String JSON_DATA = "jsonData";
      public static final String MATCH_RULES = "matchRules";
      public static final String VERSION = "version";
      public static final String MESSAGE = "message";
      public static final String UPLOAD_URL = "uploadURL";
      public static final String DOWNLOAD_URL = "downloadURL";
      public static final String DEPENDENCY_INFO = "dependencyInfo";
      public static final String DEPENDENCY_RELATIONSHIP = "dependencyRelationship";
      public static final String DEPENDENT_ON = "dependentOn";
      public static final String UOM = "uom";
      public static final String UOM_INFO = "uomInfo";
      public static final String BASE_UOM = "baseUom";
      public static final String BASE_UOM_VALUE = "baseUomValue";
      public static final String LOCALE_COALESCE = "localeCoalesce";
      public static final String FALLBACK_LOCALE = "fallbacklocale";
      public static final String LOCALE_COALESCE_PATH = "localeCoalescePath";
      public static final String LOCALE_FALLBACK_SEQUENCE = "fallbacksequence";
      public static final String COALESCE_SOURCE_ID = "coalesceSourceId";
      public static final String INSTANCE_COALESCE = "instanceCoalesce";
      public static final String COALESCE_SOURCE_NAME = "coalesceSourceName";
      public static final String COALESCE_SOURCE_TYPE = "coalesceSourceType";
      public static final String COALESCE_SOURCE_PATH = "coalesceSourcePath";
      public static final String IS_LOCALIZABLE = "isLocalizable";
      public static final String EMAIL_PARAMS = "emailParams";
      public static final String ORIGINATING_SOURCE_PATH = "osctxpath";
      public static final String CONTEXT_COALESCE = "contextCoalesce";
      public static final String PARENT_TASK_ID = "parentTaskId";
      public static final String TASK_IDS = "taskIds";
      public static final String BATCH_SIZE_SETTING_NAME = "defaultBatchSize";
      public static final String SYSTEM_INFO = "systemInfo";
      public static final String SOURCE = "source";
      public static final String SOURCES = "sources";
      public static final String STATUS = "status";
      public static final String FILE_NAME = "fileName";
   }

   public class EntityIdentifiers {
      public static final String IS_EXTERNAL_NAME = "isExternalName";
      public static final String IS_ENTITY_IDENTIFIER = "isEntityIdentifier";
      public static final String IS_UOM_FORMULA = "isUomFormula";
      public static final String IS_BASE_UOM_SYMBOL = "isBaseUomSymbol";
   }

   public class AttributeNames {
      public static final String BUSINESS_CONDITIONS = "businessConditions";
      public static final String BUSINESS_CONDITION_NAME = "businessConditionName";
      public static final String BUSINESS_CONDITION_STATUS = "businessConditionStatus";
      public static final String INCREMENT_LOAD_ERROR = "incrementLoadError";
      public static final String INCREMENT_TRANSFORM_ERROR = "incrementTransformError";
      public static final String INCREMENT_EXTRACT_ERROR = "incrementExtractError";
      public static final String INCREMENT_LOAD_IGNORE = "incrementLoadIgnore";
      public static final String INCREMENT_TRANSFORM_IGNORE = "incrementTransformIgnore";
      public static final String INCREMENT_EXTRACT_IGNORE = "incrementExtractIgnore";
   }

   public class ServiceNames {
      public static final String AUTHORIZATION = "authorizationService";
      public static final String BINARY_OBJECT_SERVICE = "binaryObjectManageService";
      public static final String CONFIGURATION_MANAGE = "configurationManageService";
      public static final String ENTITY_MANAGE = "entityManageService";
      public static final String ENTITY_MODEL = "entityModelService";
      public static final String ENTITY_GOVERN = "entityGovernService";
      public static final String ERROR_EVENT_MANAGE = "errorEventManageService";
      public static final String EVENT_MANAGE = "eventManageService";
      public static final String EXTERNAL_EVENT_MANAGE = "externalEventManageService";
      public static final String ENTITY_POST_PROCESS = "entityPostProcessService";
      public static final String ENTITY_MANAGE_MODEL = "entityManageModelService";
      public static final String REQUEST_MANAGE = "requestManageService";
      public static final String NOTIFICATION_MANAGE = "notificationManageService";
      public static final String AUTHENTICATION_SERVICE = "authenticationService";
      public static final String ENTITY_GRAPH = "entityGraphManageService";
      public static final String BINARY_STREAM_OBJECT_SERVICE = "binaryStreamObjectService";
      public static final String RESOURCE_MANAGE_SERVICE = "resourceManageService";
      public static final String EVENT_REPORT = "eventReportService";
      public static final String DIAGNOSTIC_SERVICE = "diagnosticService";
      public static final String SCHEDULE_OBJECT_MANAGE_SERVICE = "scheduleObjectManageService";
      public static final String GENERIC_OBJECT_MANAGE_SERVICE = "genericObjectManageService";
      public static final String ADMIN_SERVICE = "adminService";
      public static final String BULK_ENTITY_SERVICE = "bulkEntityService";
      public static final String BULK_EVENT_SERVICE = "bulkEventService";
      public static final String BULK_REQUEST_SERVICE = "bulkRequestService";
      public static final String IMPACT_MANAGE_SERVICE = "impactManageService";
      public static final String IMPACT_IDENTIFY_SERVICE = "impactIdentifyService";
      public static final String IMPACT_EXECUTE_SERVICE = "impactExecuteService";
      public static final String MODEL_GOVERN_SERVICE = "modelGovernService";
      public static final String SNAPSHOT_MANAGE = "snapshotManageService";
      public static final String VARIANT_MANAGE_SERVICE = "variantManageService";
      public static final String MATCH_SERVICE = "matchService";
   }

   public class Domains {
      public static final String ENTITY_DOMAIN = "dataObject";
      public static final String ENTITY_GOVERN_DOMAIN = "dataObject";
      public static final String EVENT_DOMAIN = "eventDataObject";
      public static final String ENTITY_MODEL_DOMAIN = "dataModelDataObject";
      public static final String CONFIG_DOMAIN = "configDataObject";
      public static final String AUTHORIZATION_DOMAIN = "authorizationDataObject";
      public static final String REQUEST_DOMAIN = "requestDataObject";
      public static final String BINARY_OBJECT = "binaryDataObject";
      public static final String BINARY_STREAM_OBJECT = "binaryStreamDataObject";
      public static final String NOTIFICATION_OBJECT = "notificationDataObject";
      public static final String INTERNAL_EVENT_DOMAIN = "internalEventDataObject";
      public static final String DELETE_ENTITY_DOMAIN = "deleteDataObject";
      public static final String DIAGNOSTIC_OBJECT = "diagnosticObject";
      public static final String SCHEDULE_OBJECT_DOMAIN = "scheduleDataObject";
      public static final String ADMIN_OBJECT = "adminDataObject";
      public static final String GENERIC_OBJECT_DOMAIN = "genericDataObject";
   }

   public final class ContextTypes {
      public static final String SELF = "self";
      public static final String ATTRIBUTE = "attribute";
      public static final String SOURCE = "source";
      public static final String LOCALE = "locale";
      public static final String REFERENCE_DATA = "referenceData";
      public static final String TIMESTAMP = "timestamp";
      public static final String CLASSIFICATION = "classification";
      public static final String VARIANT_IDS_PATH = "variantIdsPath";
      public static final String VARIANT_NAMES_PATH = "variantNamesPath";
      public static final String WORKFLOW = "workflow";
      public static final String TAXONOMY = "taxonomy";
      public static final String LIST = "list";
      public static final String LOCALE_COALESCE = "localeCoalesce";
      public static final String GETNEAREST_DEFAULT_CONTEXT_TYPE = "_DEFAULT";
      public static final String INTERNAL_SOURCE = "internal";
      public static final String ENGLISH_LOCALE = "en-US";
      public static final String SNAPSHOT = "snapshot";
   }

   /**
    * Class containing the string constants representing the context path prefixes
    */
   public final class ContextPathPrefixes {
      public static final String ATTRIBUTE = "attributeModels/";
      public static final String VALUE_ID = "valueIds/";
      public static final String PROPERTIES = "properties/";
      public static final String RELATIONSHIPS = "relationships/";
      public static final String RELATIONSHIP_ATTRIBUTES = "relationshipAttributes/";
   }

   public final class SystemProperties {
      public static final String LOGGING_DIR = "rs.logging.dir";
      public static final String PROFILER_PERF_LOG_CATEGORY = "Diagnostic.Profiler";
      public static final String THRESHOLD_LOG_CATEGORY = "Diagnostic.Threshold";
   }

   public final class LoggingContext {
      public static final String GUID = "GUID";
      public static final String ID = "id";
      public static final String INCLUSIVE_TIME = "inclusiveTime";
      public static final String METHOD = "method";
      public static final String METHOD_LIST = "methodList";
      public static final String START_TIME = "startTime";
      public static final String REQUESTID = "requestId";
      public static final String RELATED_REQUESTID = "relatedRequestId";
      public static final String GROUP_REQUESTID = "groupRequestId";
      public static final String TENANT_ID = "tenantId";
      public static final String USERID = "userId";
      public static final String CALLERSERVICE_NAME = "callerServiceName";
      public static final String CALLEESERVICE_NAME = "calleeServiceName";
      public static final String INFO_START_TIME = "infoStartTime";
      public static final String TASKID = "taskId";
      public static final String UNKNOWN = "unknown";
      public static final String MESSAGE_CODE = "messageCode";
      public static final String INSTANCE_ID = "instanceId";
      public static final String LOG_LEVEL = "logLevel";
   }

   public class ObjectTypes {
      public static final String ENTITY_TYPE_MODEL = "entityType";
      public static final String ENTITY_MANAGE = "entity";
      public static final String MANAGE_MODEL = "entityManageModel";
      public static final String GOVERN_MODEL = "entityGovernModel";
      public static final String VALIDATION_MODEL = "entityValidationModel";
      public static final String DEFAULT_VALUES_MODEL = "entityDefaultValuesModel";
      public static final String ATTRIBUTE_MODEL = "attributeModel";
      public static final String VARIANT_MODEL = "entityVariantModel";
      public static final String BUSINESS_RULE = "businessRule";
      public static final String RULE_CONTEXT_MAPPINGS = "ruleContextMappings";
      public static final String BUSINESS_RULE_MODEL = "businessRuleModel";
      public static final String BUSINESS_CONDITION = "businessCondition";
      public static final String AUTHORIZATION_MODEL = "authorizationModel";
      public static final String ROLE_COMPUTE_POLICY = "rolecomputepolicy";
      public static final String WORKFLOW_DEFINITION = "workflowDefinition";
      public static final String USER = "user";
      public static final String MATCH_CONFIG = "matchConfig";
      public static final String RDP_CONFIG = "rdpConfig";
      public static final String CONTEXT_MODEL = "entityContextModel";
      public static final String WORKFLOW_DEFINITION_MAPPING = "workflowDefinitionMapping";
      public static final String SCHEDULED_REQUEST_OBJECT = "scheduledrequestobject";
      public static final String REQUEST_OBJECT_TYPE = "requestobject";
      public static final String REQUEST_OF_REQUEST_OBJECT_TYPE = "requestofrequestsobject";
      public static final String TASK_SUMMARY_OBJECT_TYPE = "tasksummaryobject";
      public static final String ASSIGNMENT_NOTIFICATION = "assignmentNotification";
      public static final String TASK_NOTIFICATION = "taskNotification";
      public static final String NOTIFICATION_TYPE = "notificationType";
      public static final String VARIANT_MODEL_SETTINGS = "variantModelSettings";
      public static final String DOMAIN = "domain";
      public static final String LOCALE = "locale";
      public static final String PLATFORM_SERVICE_CONFIG = "platformServiceConfig";
      public static final String BINARY_STREAM_OBJECT = "binaryStreamObject";
   }

   public class DataTypes {
      public static final String INTEGER = "integer";
      public static final String DECIMAL = "decimal";
      public static final String BOOLEAN = "boolean";
      public static final String NUMERIC = "numeric";
      public static final String DATE = "date";
      public static final String DATE_TIME = "datetime";
      public static final String STRING = "string";
   }

   public class DataTypeFormats {
      public static final String BOOL_VALUE_ATTRIBUTE = "boolValue";
      public static final String INT_VALUE_ATTRIBUTE = "intValue";
      public static final String DECIMAL_VALUE_ATTRIBUTE = "decValue";
      public static final String DATE_VALUE_ATTRIBUTE = "dateValue";
      public static final String DATE_TIME_VALUE_ATTRIBUTE = "dateTimeValue";
      public static final String INVALID_VALUE_ATTRIBUTE = "invalidValue";
      public static final String PROPERTY_BOOL_VALUE = "propertyBoolValue";
      public static final String PROPERTY_INT_VALUE = "propertyIntValue";
      public static final String PROPERTY_DECIMAL_VALUE = "propertyDecValue";
      public static final String PROPERTY_DATE_VALUE = "propertyDateValue";
      public static final String PROPERTY_DATE_TIME_VALUE = "propertyDateTimeValue";
      public static final String PROPERTY_VALUE = "propertyValue";
   }

   public class DataOperands {
      public static final String OR_OPERAND = "_OR";
      public static final String AND_OPERAND = "_AND";
      public static final String EXACT_OPERAND = "_EXACT";
   }

   public class GetParams {
      public static final String PARAMS = "params";
      public static final String SORT_FIELDS = "sort";
      public static final String OPTIONS = "options";
      public static final String IDS = "ids";
      public static final String OPERATOR = "operator";
      public static final String RANGE = "range";
      public static final String RESULT_RANGE = "resultRange";
      public static final String HAS_VALUE = "hasvalue";
      public static final String NOT = "not";
      public static final String DISTINCT = "distinct";
      public static final String AGGREGATE = "aggregate";
      public static final String GROUP_BY = "groupBy";
      public static final String VALUE_PROPERTIES = "valueProperties";
      public static final String CREATE_VARIANTS = "createVariants";
      public static final String NON_VALUE_CONTEXTUAL = "nonValueContextual";
      public static final String EXCLUDE_NON_CONTEXTUAL = "excludeNonContextual";
      public static final String NON_CONTEXTUAL = "nonContextual";
      public static final String ALL_CONTEXTUAL = "allContextual";
      public static final String CTX_TYPES = "ctxTypes";
      public static final String DETAILS = "details";
      public static final String EXACT = "exact";

      public class OPTIONS_PARAMS {
         public static final String TOTAL_RECORDS = "totalRecords";
         public static final long DEFAULT_SIZE = 5000;
         public static final String SIZE = "size";
         public static final String FROM = "from";
         public static final String GETNEAREST_PATH = "getnearestPath";
         public static final String GETNEAREST_RETURN_ALL = "getnearestReturnAll";
         public static final String CONTEXT_EXACT_MATCH = "contextExactMatch";
         public static final String MAX_RECORDS = "maxRecords";
         public static final String COALESCE_OPTIONS = "coalesceOptions";
      }

      public class PROPERTY_PARAMS {
         public static final String COALESCE = "coalesce";
         public static final String COALESCE_ID = "coalesceId";
         public static final String COALESCE_TYPE = "coalesceType";
      }
      public static final String DEFAULT_MAX_RECORDS = "defaultMaxRecords";
      public static final String GETNEAREST_MAX_CONTEXTS = "getnearestMaxContexts";

      public static final long RESPONSE_SIZE = 2000;
      public static final String VALUE_CONTEXTS = "valueContexts";
      public static final String CONTEXTS = "contexts";
      public static final String FIELDS = "fields";
      public static final String QUERY = "query";
      public static final String SCROLL_ID = "scrollId";
      public static final String PREPARE_SCROLL = "prepareScroll";
      public static final String FILTERS = "filters";
      public static final String ATTRIBUTES_CRITERION = "attributesCriterion";
      public static final String TYPES_CRITERION = "typesCriterion";
      public static final String SOURCES_CRITERION = "sourcesCriterion";
      public static final String PROPERTIES_CRITERION = "propertiesCriterion";
      public static final String RELATIONSHIPS_CRITERION = "relationshipsCriterion";
      public static final String RELATIONSHIPATTRIBUTES_CRITERION = "relationshipAttributesCriterion";
      public static final String KEYWORDS_CRITERION = "keywordsCriterion";
      public static final String REQUEST_PARAMS = "requestParams";
      public static final String ATTRIBUTESPATH = "attributePaths";
      public static final String RELATIONSHIPSPATH = "relationshipPaths";
      public static final String PROPERTYPATHS = "propertyPaths";
      public static final String OBJECT_PATHS = "objectPaths";
      public static final String PROPERTY_NAME = "propertyName";
      public static final String ATTRIBUTES_CRITERION_OR_FLAG = "isAttributesCriterionOR";
      public static final String RESULT = "result";
      public static final String KEYWORDS= "keywords";
      public static final String KEYWORD= "keyword";
   }

   public final class MessageTypes {
      public static final String ERROR = "error";
      public static final String WARNING = "warning";
      public static final String SUCCESS = "success";
      public static final String COMPLETED = "COMPLETED";
   }

   public final class TaskStatus {
      public static final String QUEUED = "Queued";
      public static final String PROCESSING = "Processing";
      public static final String ERRORED = "Errored";
      public static final String STARTED = "Started";
      public static final String COMPLETED = "Completed";
      public static final String COMPLETED_WITH_ERRORS = "Completed With Errors";
   }

   public final class Actor {
      public static final String ApiService = "ApiService";
      public static final String SearchStore = "SearchStore";
      public static final String ObjectStore = "ObjectStore";
      public static final String ManageRulePreparation = "ManageRulePreparation";
      public static final String ManageRuleRun = "ManageRuleRun";
      public static final String GovernRulePreparation = "GovernRulePreparation";
      public static final String GovernRuleRun = "GovernRuleRun";
      public static final String PostProcessRulePreparation = "PostProcessRulePreparation";
      public static final String PostProcessRuleRun = "PostProcessRuleRun";
   }

   public final class TaskSummaryAttributes {
      public static final String TOTAL_EXTRACT_ERROR = "totalExtractError";
      public static final String TOTAL_LOAD_ERROR = "totalLoadError";
      public static final String TOTAL_TRANSFORM_ERROR = "totalTransformError";
      public static final String TOTAL_EXTRACT_IGNORE = "totalExtractIgnore";
      public static final String TOTAL_LOAD_IGNORE = "totalLoadIgnore";
      public static final String TOTAL_TRANSFORM_IGNORE = "totalTransformIgnore";
      public static final String TOTAL_RECORDS = "totalRecords";
      public static final String TOTAL_RDP_ERRORS = "totalRDPErrors";
      public static final String TOTAL_RECORDS_SUCCESS = "totalRecordsSuccess";
      public static final String TOTAL_RECORDS_PROCESSED = "totalRecordsProcessed";
      public static final String TOTAL_RECORDS_CREATE = "totalRecordsCreate";
      public static final String TOTAL_RECORDS_UPDATE = "totalRecordsUpdate";
      public static final String TOTAL_RECORDS_DELETE = "totalRecordsDelete";
      public static final String TOTAL_RECORDS_NO_CHANGE = "totalRecordsNoChange";
      public static final String TOTAL_TRANSFORM_SUCCESS = "totalTransformSuccess";
   }

   public final class RequestStatus {
      public static final String QUEUED = "queued";
      public static final String IN_PROGRESS = "inProgress";
      public static final String ERROR = "error";
      public static final String SUCCESS = "success";
   }

   public final class EventProperties {
      public static final String EVENT_TARGET = "eventTarget";
      public static final String EVENT_DETAILS = "eventDetails";
   }

   public final class Action {
      public static final String CREATE = "create";
      public static final String CREATE_SNAPSHOT = "createsnapshot";
      public static final String UPDATE = "update";
      public static final String DELETE = "delete";
      public static final String FORCEDELETE = "forcedelete";
      public static final String DELETE_SNAPSHOT = "deletesnapshot";
      public static final String REEVALUATE = "reevaluate";
      public static final String REPLACE = "replace";
      public static final String READ = "read";
      public static final String NO_CHANGE = "nochange";
      public static final String SYSTEM_UPDATE = "systemupdate";
      public static final String PREPARE_UPLOAD = "prepareUpload";
      public static final String PREPARE_DOWNLOAD = "prepareDownload";
      public static final String PREPARE_MULTIPLE_DOWNLOAD = "prepareMultipleDownload";
      public static final String RESTORE_SNAPSHOT = "restoresnapshot";
      public static final String RESTORE = "restore";
      public static final String GENERATE_VARIANTS = "generatevariants";
      public static final String SEND_MESSAGE = "sendMessage";
      public static final String NORMAL_EXECUTION_BOLT = "normalExecutionBolt";
   }

   public final class TenantConfigProperties {
      public static final String TENANT_LIST = "tenantList";
      public static final String TENANT_LIST_DATA_TYPE = "tenantconfiglist";
      public static final String TENANT_SERVICE_CONFIG_DATA_TYPE = "tenantserviceconfig";
      public static final String EVENT_TO_SERVICE_MAPPING = "eventToServiceMapping";
   }

   public final class ApiVerbs {
      public static final String GET = "get";
      public static final String GET_COALESCE = "getcoalesce";
      public static final String GET_CONTEXT = "getcontext";
      public static final String EXISTS_BY_ID = "existsById";
      public static final String GET_NEAREST = "getnearest";
   }

   public final class RequestObjectAttributeNames {
      public static final String REQUEST_ID = "requestId";
      public static final String REQUEST_TIMESTAMP = "requestTimestamp";
      public static final String RELATED_REQUEST_ID = "relatedRequestId";
      public static final String REQUEST_GROUP_ID = "requestGroupId";
      public static final String REQUEST_STATUS = "requestStatus";
      public static final String CLIENT_ID = "clientId";
      public static final String USER_ID = "userId";
      public static final String CLIENT_STATE = "clientState";
      public static final String ENTITY_ACTION = "entityAction";
      public static final String ENTITY_ID = "entityId";
      public static final String ENTITY_TYPE = "entityType";
      public static final String REQUEST_OF_REQUESTS = "requestOfRequests";
      public static final String IMPERSONATE_CLIENT_ID = "impersonateClientId";
      public static final String ORIGINATING_CLIENT_ID = "originatingClientId";
      public static final String IMPERSONATE_USER_ID = "impersonateUserId";
      public static final String TASK_ID = "taskId";

      public static final String START_TIME = "startTime";
      public static final String LAST_MODIFIED_TIME = "lastModifiedTime";
      public static final String TOTAL_RECORDS_PROCESSED = "totalRecordsProcessed";
      public static final String TOTAL_RECORDS_SUCCESS = "totalRecordsSuccess";
      public static final String TOTAL_RECORDS_ERROR = "totalRecordsError";
      public static final String TOTAL_RECORDS_CREATE = "totalRecordsCreate";
      public static final String TOTAL_RECORDS_UPDATE = "totalRecordsUpdate";
      public static final String TOTAL_RECORDS_DELETE = "totalRecordsDelete";
      public static final String TOTAL_RECORDS_NO_CHANGE = "totalRecordsNoChange";
      public static final long MAX_TASK_DETAILS = 30000;
      public static final boolean INCLUDE_TASK_DETAILS = false;
   }

   public final class SystemDefaults {
      public static final boolean EVENT_PERSISTENCE_ENABLED = true;
      public static final boolean PERSIST_CREATE_EVENT_DATA = false;
      public static final boolean SOFT_DELETE_ENABLED = false;
      public static final boolean EXTERNAL_EVENT_PERSISTENCE_ENABLED = true;
      public static final boolean IS_BULK_REFERENCE_RESOLUTION_ENABLED = true;
      public static final boolean OBJECT_STORE_PERSISTENCE_ENABLED = false;
   }

   public final class Client {
      public static final String RUF_CLIENT = "rufClient";
      public static final String COP_CLIENT = "copClient";
      public static final String GOVERNANCE_CLIENT = "governanceClient";
      public static final String RSDAM_CLIENT = "rsdamClient";
   }

   public final class DefaultProperties {
      public static final String CREATED_SERVICE = "createdService";
      public static final String CREATED_BY = "createdBy";
      public static final String CREATED_DATE = "createdDate";
      public static final String MODIFIED_SERVICE = "modifiedService";
      public static final String MODIFIED_BY = "modifiedBy";
      public static final String MODIFIED_DATE = "modifiedDate";
   }

   public final class AuthHeaders {
      public static final String X_RDP_PREFIX = "x-rdp-";
      public static final String X_RDP_OWNERSHIP_DATA = "x-rdp-ownershipData";
      public static final String X_RDP_OWNERSHIP_EDIT_DATA = "x-rdp-ownershipEditData";
      public static final String X_RDP_USER_ROLES = "x-rdp-userRoles";
      public static final String X_RDP_USER_ID = "x-rdp-userId";
      public static final String X_RDP_CLIENT_ID = "x-rdp-clientId";
      public static final String X_RDP_TENANT_ID = "x-rdp-tenantId";
   }

   public final class Authorization {
      public static final String ROLE_COMPUTE_POLICY = "roleComputePolicy";
      public static final String ROLE = "role";
      public static final String GROUPS = "groups";
      public static final String ROLES = "roles";
      public static final String MAPPING = "mapping";
      public static final String RANK = "rank";
      public static final String DEFAULT_ROLE = "default-role";
      public static final String POLICY_TYPE = "policy-type";
   }

   public final class CacheProperties {
      public static final String IS_CACHE_ENABLED_PROPERTY = "isCacheEnabled";
      public static final boolean isCacheEnabled = false;
      public static final boolean isModelCoalesceCacheEnabled = false;
      public static final String localCacheType = "local";
      public static final String timeBasedCacheExpirationType = "timeBased";
      public static final int maxCacheEntries = 1000;
      public static final int cacheExpirationMs = 1800000;
      public static final String MAX_CACHE_ENTIRES = "maxCacheEntries";
      public static final String CACHE_EXPIRATION_MS = "cacheExpirationMs";
   }

   public static final class PerformanceThresholds {
      public static final Integer MIN_ALLOWED_LATENCY_THRESHOLD = 100;
      public static final Integer SEARCHSTORE_GET = 100;
      public static final Integer SEARCHSTORE_DELETE = 1000;
      public static final Integer SEARCHSTORE_PERSIST = 100;
      public static final Integer OBJECTSTORE_GET = 100;
      public static final Integer OBJECTSTORE_PERSIST = 100;
      public static final Long ALLOWABLEDELAYBEFOREREVALIDATECREATEACTION = 0L;
      public static final Integer FIND_RULES = 500;
      public static final Integer PRELOAD_DATA_FOR_RULES = 250;
      public static final Integer DEFAULT_VALUES_POPULATION = 200;
      public static final Integer VALIDATE_INVALID_DATA = 100;
      public static final Integer VALIDATE_MODEL_RULES = 300;
      public static final Integer RUN_BUSINESS_RULES = 500;
      public static final Integer REFERENCE_RESOLUTION = 400;
      public static final Integer GRAPH_IDENTIFICATION = 500;
      public static final Integer GRAPH_EXECUTION = 500;
      public static final Integer IMPACT_EXECUTION = 500;
      public static final Integer EXTRACT_PHASE = 5000;
      public static final Integer STATUS_UPDATE = 500;
      public static final Integer ENTITY_RESOLUTION = 500;
      public static final Integer REQUEST_SUBMIT = 500;
      public static final Integer SPLIT_COMPLETION = 500;
      public static final Integer USERNAME_GET_AUTOASSIGNMENT = 200;
      public static final Integer VARIANT_BUILD_MAP = 200;
      public static final Integer VARIANT_CARTESIAN_COMPLETION = 500;
      public static final Integer VARIANT_EXIST_RESOLUTION = 2000;
      public static final Integer EVENT_DISPATCHER_SINGLE = 200;
      public static final Integer EVENT_DISPATCHER_ALL = 500;
      public static final long LARGE_OBJECT_MESSAGE_SIZE = 1000012;
   }

   public final class Topology {
      public static final String STORM_TOPOLOGIES = "stormTopologies";
      public static final String DEPLOYMENT_MODE = "deploymentMode";
      public static final String CONFIG_PATH = "configPath";
      public static final String INBOUND_DOMAIN = "inboundDomain";
      public static final String BUILDER_CLASS = "topologyBuilderClass";
      public static final String ARTIFACT = "artifact";
      public static final String SERVICE_NAME = "serviceName";
      public static final String STORM_SERVER_MODE = "server";
      public static final String STORM_LOCAL_MODE = "local";
      public static final String SUBMIT_METHOD_NAME = "submit";
      public static final String REQUEST_FIELD = "request";
      public static final String MODEL_FIELD = "model";
      public static final String ORIGINAL_ENTITY_FIELD = "entity";
      public static final String MERGED_ENTITY_FIELD = "mergedEntity";
      public static final String COMPARE_DATA_FIELD = "compareData";
      public static final String FIELDS_GROUPING_FIELD = "entityId";
      public static final String REQUEST_TRACKING_FIELD = "requestTracking";
      public static final String GRAPH_PROCESS_CONFIG_FIELD = "graphprocessconfig";
   }

   // Model sources
   public static final String DEFAULT_MODEL_SOURCE = "tenant";
   public static final String CONSOLIDATED_MODEL_SOURCE = "internal";
   public static final String PLATFORM_MODEL_SOURCE = "platformSeed";

   public static final class MetricsProperties {
      public static final boolean METRICS_ENABLED = false;
   }

   public static final class MessageProperties {
      public static final String LOCALES = "locales";
      public static final String TEXT = "text";
      public static final String RESOURCES = "resources";
      public static final String MESSAGE_CODE = "messagecode";
      public static final String SERVICE_NAME = "servicename";
      public static final String MESSAGE_TEXT = "messagetext";
      public static final String MESSAGE_TEXT_CC = "messageText";
      public static final String MESSAGE_TYPE_CC = "messageType";
      public static final String MESSAGE_DESCRIPTION_CC = "messageDesc";
      public static final String MESSAGE_DESCRIPTION = "messagedescription";
      public static final String MESSAGE_TYPE = "messagetype";
   }

   public final class OriginatingSources {
      public static final String BusinessRule = "businessRule";
      public static final String Defaults = "defaults";
      public static final String DefaultValuesModel = "entityDefaultValuesModel";
      public static final String Graph = "graph";
   }

   public final class ContextProperties {
      public static final String ORIGINAL_CONTEXT = "originalcontext";
   }

   public final class EmailProperties {
      public static final String TO = "to";
      public static final String CC = "cc";
      public static final String SUBJECT = "subject";
      public static final String BODY = "body";
      public static final String SUBJECT_TEMPLATE = "subjecttemplate";
      public static final String BODY_TEMPLATE = "bodytemplate";
      public static final String BODY_CONTENT_TEMPLATE = "bodycontenttemplate";
      public static final String GROUP_TEMPLATE = "grouptemplate";
      public static final String ROW_TEMPLATE = "rowtemplate";
      public static final String EMAIL = "email";
      public static final String SUBSCRIBED_ROLES = "subscribedroles";
      public static final String SUBSCRIBED_USERS = "subscribedusers";
      public static final String EXCLUDED_USERS = "excludedusers";
      public static final String IS_EMAIL_NOTIFICATION_ENABLED = "isEmailNotificationEnabled";
      public static final String IS_ENTITY_LOAD_REQUIRED = "entityLoadRequired";
   }

   public final class ElasticSearch {
      public static final String ENTITY_SEARCH_TEMPLATE = "EntityGet";
      // NOTE: Keep version in with EntityGetTemplate.mustache.
      public static final String ENTITY_SEARCH_TEMPLATE_VERSION = "<%!EntityGet.Version=11%>";
      public static final String ENTITY_SEARCH_TEMPLATE_VERSION_MATCH = "(<%!EntityGet.Version=[0-9\\.]+%>)";
      public static final String ENTITY_SEARCH_TEMPLATE_LANGUAGE= "mustache";
      public static final String ENTITY_SORT_SCRIPT = "EntitySort";
      // NOTE: Keep version in with EntitySortScript.
      public static final String ENTITY_SORT_SCRIPT_VERSION = "[EntitySort.Version=1]";
      public static final String ENTITY_SORT_SCRIPT_VERSION_MATCH = "(\\[EntitySort.Version=[0-9\\.]+\\])";
      public static final String ENTITY_SORT_SCRIPT_LANGUAGE= "groovy";
      // NOTE: Keep version in with consolidated_dataobject_mapping.json.
      // Min version represents the oldest compatible mapping version.
      // Max version should be set the current mapping version at time of the build.
      public static final int INDEX_MAPPING_MIN_VERSION = 3;
      public static final int INDEX_MAPPING_MAX_VERSION = 5;
   }

   public class PermissionNames {

      public static final String ATTRIBUTES_PERMISSION = "attributesPermission";
      public static final String RELATIONSHIPS_PERMISSION = "relationshipsPermission";
      public static final String CONTEXTS_PERMISSION = "contextsPermission";
      public static final String CONTEXT_ATTRIBUTES_PERMISSION = "contextsAttributesPermission";
      public static final String CONTEXT_RELATIONSHIPS_PERMISSION = "contextsRelationshipsPermission";
   }

   public class PermissionTypes {
      public static final String WRITE_PERMISSION = "writePermission";
      public static final String READ_PERMISSION = "readPermission";
      public static final String OWNER_PERMISSION = "ownerPermission";
      public static final String DELETE_PERMISSION = "deletePermission";
      //PBL 301491 - New header option
      public static final String OWNER_EDIT_PERMISSION = "ownerEditPermission";
   }

   public final class RelationshipOwnership {
      public static final String BACKWARD_RELATIONSHIP_OWNERSHIP = "whereused";
      public static final String FORWARD_RELATIONSHIP_OWNERSHIP = "owned";
   }

   public final class ELASTIC_MAPPING_PROPERTIES {
      public static final String REPLICA_COUNT = "replicaCount";
      public static final String CONTEXT_DELIMITER = "contextDelimiter";
      public static final String CASE_SENSITIVE_VALUE = "caseSensitiveValue";
   }

   //validation related
   public final class Validation {
      public static final String TECHNOLOGY = "technology";
      public static final String ERROR = "Error";
      public static final String SUCCESS = "Success";
      public static final String CONTAINER_NOT_EXIST = "Does not exist";
      public static final String CONTAINER_NAME_WITHOUT_INSTANCEID_TENANTID = "Container name is incorrect in tenant config as doesn't contain correct instanceId and tenantId.";
      public static final String CONTAINER_NAME_WITHOUT_TENANTID = "Container name is incorrect in tenant config as doesn't contain tenantId.";
   }

   public final class CacheNames {
      public static final String CONFIG = "config";
      public static final String MODEL = "model";
      public static final String NAME_ID_RESOLUTION = "nameIdResolution";
      public static final String EVENT_HUB_STREAM_CLIENT = "eventHubStreamClient";
      public static final String OBJECT_STORAGE_PROVIDER_CLIENT = "objectStorageProviderClient";
      public static final String TYPE_DOMAIN_RESOLUTION = "typeDomainResolution";
   }

   public final class RelationshipsAttributes {
      public static final String HAS_IMAGES = "hasimages";
      public static final String HAS_VIDEO = "hasvideo";
      public static final String HAS_AUDIO = "hasaudio";
      public static final String HAS_DOCUMENTS = "hasdocuments";
   }
}